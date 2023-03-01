package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.dto.user.UserChangePasswordDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserCreateDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserUpdateDTO;
import DKSPACE.PhamarERP.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl extends AbstractBaseCRUDService<User, UserRepository> implements UserService {

    protected UserServiceImpl(UserRepository repository) {
        super(repository);
    }


    @Override
    public Object listUser() {
        return null;
    }

    @Override
    public User createUser(UserCreateDTO dto) {
        User user = buildUser(dto);
        return user;

    }

    private User buildUser(UserCreateDTO dto) {
        return User.builder()
                   .email(dto.getEmail())
                   .password(dto.getPassword())
                   .username(dto.getUsername())
                   .phoneNumber(dto.getPhoneNumber())
                   .type(UserType.valueOf(dto.getType()))
                   .firstName(dto.getFirstName())
                   .lastName(dto.getLastName())
                   .isActive(dto.getIsActive())
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
