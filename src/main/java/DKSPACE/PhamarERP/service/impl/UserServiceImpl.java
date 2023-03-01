package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.mapper.UserMapper;
import DKSPACE.PhamarERP.master_data.dto.user.UserChangePasswordDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserCreateDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserResDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserUpdateDTO;
import DKSPACE.PhamarERP.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl extends AbstractBaseCRUDService<User, UserRepository> implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    protected UserServiceImpl(UserRepository repository,
                              UserMapper userMapper,
                              PasswordEncoder passwordEncoder) {
        super(repository);
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Object listUser() {
        return null;
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
        return null;
    }

    @Override
    public Object toggleActiveUser(Long id) {
        return null;
    }

    @Override
    public Object addRoles(Long id, List<Long> rolesId) {
        return null;
    }

    @Override
    public Object exportUser() {
        return null;
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
