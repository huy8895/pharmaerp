package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.excel.ExcelHelper;
import DKSPACE.PhamarERP.mapper.UserMapper;
import DKSPACE.PhamarERP.master_data.dto.user.*;
import DKSPACE.PhamarERP.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
public class UserServiceImpl extends AbstractBaseCRUDService<User, UserRepository> implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    protected final ExcelHelper excelHelper;
    protected UserServiceImpl(UserRepository repository,
                              UserMapper userMapper,
                              PasswordEncoder passwordEncoder, ExcelHelper excelHelper) {
        super(repository);
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.excelHelper = excelHelper;
    }

    @Override
    public User findOne(Long id) {
        return repository.findByIdAndDeletedAtIsNull(id)
                         .filter(user -> !UserType.SUPER_ADMIN.equals(user.getType()))
                         .orElseThrow();
    }

    @Override
    public Object listUser(Pageable pageable) {
        return super.findAll(pageable);
    }

    @Override
    public UserResDTO createUser(UserCreateDTO dto) {
        User user = buildUser(dto);
        return userMapper.toDTO(super.save(user));
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
    public Object importUser() {
        return null;
    }

    @Override
    public Object changePassword(UserChangePasswordDTO dto) {
        return null;
    }
}
