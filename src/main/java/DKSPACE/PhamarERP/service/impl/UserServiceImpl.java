package DKSPACE.PhamarERP.service.impl;

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
    public Object createUser(UserCreateDTO dto) {
        return null;
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
