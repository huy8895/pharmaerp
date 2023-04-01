package DKSPACE.PhamarERP.user.service.impl;

import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.model.User_;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.general.enums.ObjectType;
import DKSPACE.PhamarERP.general.model.Uploadable_;
import DKSPACE.PhamarERP.general.service.MailService;
import DKSPACE.PhamarERP.helper.excel.ExcelHelper;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ClientException;
import DKSPACE.PhamarERP.user.dto.criteria.UserCriteria;
import DKSPACE.PhamarERP.user.dto.user.*;
import DKSPACE.PhamarERP.user.mapper.UserMapper;
import DKSPACE.PhamarERP.user.service.UserService;
import DKSPACE.PhamarERP.user.service.criteria.UserQueryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl extends AbstractBaseCRUDService<User, UserRepository> implements UserService {
    
    public static final String PASS_DEFAULT = "PharmaERP@2023";
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    protected final ExcelHelper excelHelper;
    private final MailService mailService;
    private final FilterService<User, UserCriteria> queryService;
    protected UserServiceImpl(UserRepository repository,
                              UserMapper userMapper,
                              PasswordEncoder passwordEncoder,
                              ExcelHelper excelHelper,
                              MailService mailService,
                              UserQueryService userQueryService) {
        super(repository);
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.excelHelper = excelHelper;
        this.mailService = mailService;
        this.queryService = userQueryService;
    }

    @Override
    public User findOne(Long id) {
        return repository.findByIdAndDeletedAtIsNull(id)
                         .filter(user -> !UserType.SUPER_ADMIN.equals(user.getType()))
                         .orElseThrow();
    }

    @Override
    public Page<UserResDTO> listUser(UserCriteria userCriteria, Pageable pageable) {
        return queryService.findByCriteria(userCriteria, pageable, repository::findAll)
                .map(userMapper::toDTO);
    }

    @Override
    public UserResDTO createUser(UserCreateDTO dto) {
        User user = buildUser(dto);
        User createdUser = super.save(user);
        mailService.sendCreationEmail(createdUser, dto.getPassword());
        return userMapper.toDTO(createdUser);
    }

    private User buildUser(UserCreateDTO dto) {
        return User.builder()
                   .email(dto.getEmail())
                   .password(passwordEncoder.encode(dto.getPassword().trim()))
                   .username(dto.getUsername())
                   .phoneNumber(dto.getPhoneNumber())
                   .type(UserType.valueOf(dto.getType()))
                   .firstName(dto.getFirstName())
                   .lastName(dto.getLastName())
                   .isActive(true)
                   .staffCode(dto.getStaffCode())
                   .build();
    }

    @Override
    public Object updateUser(UserUpdateDTO dto) {
        User userToUpdate = userMapper.toEntity(dto);
        return super.partialUpdate(userToUpdate);
    }

    @Override
    public Object toggleActiveUser(Long id) {
        User user = this.findOne(id);
        user.setIsActive(!user.getIsActive());
        return this.save(user);
    }

    @Override
    public Object updateRolesUser(UserAddRolesDTO dto) {

        User currentUser = this.findOne(dto.getId());

        currentUser.setRoles(Collections.emptySet());
        User updatedUser = super.save(currentUser);

        updatedUser.setRoles(userMapper.toEntity(dto).getRoles());
        return super.save(updatedUser);
    }

    @Override
    public byte[] exportUser() {
        final var content = findAll(Pageable.unpaged())
                .map(userMapper::toDTO)
                .getContent();
        return excelHelper.writeFile(content, UserResDTO.class);
    }

    @Override
    public List<UserCreateDTO> importUser(MultipartFile file) {
        return excelHelper.readFile(file, UserCreateDTO.class).stream()
                          .map(this::checkPasswordBlankAndSetDefault)
                          .collect(Collectors.toList());
    }
    
    private UserCreateDTO checkPasswordBlankAndSetDefault(UserCreateDTO dto) {
        final var password = dto.getPassword();
        if (!StringUtils.isBlank(password)) {
            dto.setPassword(password.trim());
            return dto;
        }
        dto.setPassword(PASS_DEFAULT);
        return dto;
    }
    @Override
    public void changePassword(UserChangePasswordDTO dto) {
        if (!dto.getConfirmPassword().equals(dto.getNewPassword())){
            throw new ClientException(ApiResponseInfo.PASSWORD_CONFIRM_NOT_MATCH);
        }
        
        User user = this.findOne(dto.getId());
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        this.save(user);
        mailService.sendMailChangedPassword(user ,dto.getNewPassword());
    }
    
    @Override
    public Object exportTemplate() {
        return excelHelper.exportTemplate(UserCreateDTO.class);
    }
    
    @Override
    public Object saveListUser(@Valid UserCreateListDTO dtos) {
        final var users = dtos.getListUser()
                              .stream()
                              .map(this::buildUser)
                              .toList();
        return saveList(users);
    }
	
	@Override
	public Object detailUser(Long userId) {
        return getUserUsingSpecification();
    }
    
    private Optional<User> getUserUsingSpecification() {
        Specification<User> spec = (root, query, criteriaBuilder) -> {
//            final var uploadableSetJoin = root.join(User_.uploadables);
            final var objectPath = root.join(User_.uploadables).get(Uploadable_.objectType);
            query.distinct(true);
            return criteriaBuilder.equal(objectPath, ObjectType.USER.name());
        };
        return repository.findOne(spec);
    }
    
    public static Specification<User> hasId(Long id) {
        return (root, query, cb) -> cb.equal(root.get(User_.id), id);
    }
    

}
