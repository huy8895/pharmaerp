package DKSPACE.PhamarERP.service;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.BaseCRUDService;
import DKSPACE.PhamarERP.master_data.dto.user.UserChangePasswordDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserCreateDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserUpdateDTO;

import java.util.List;

public interface UserService extends BaseCRUDService<User> {
    Object listUser();

    Object createUser(UserCreateDTO dto);

    Object updateUser(UserUpdateDTO dto);

    Object toggleActiveUser(Long id);

    Object addRoles(Long id, List<Long> rolesId);

    Object exportUser();

    Object importUser();

    Object changePassword(UserChangePasswordDTO dto);
}