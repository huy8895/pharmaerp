package DKSPACE.PhamarERP.service;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.BaseCRUDService;
import DKSPACE.PhamarERP.master_data.dto.user.UserAddRolesDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserChangePasswordDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserCreateDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserUpdateDTO;
import org.springframework.data.domain.Pageable;

public interface UserService extends BaseCRUDService<User> {
    Object listUser(Pageable pageable);

    Object createUser(UserCreateDTO dto);

    Object updateUser(UserUpdateDTO dto);

    Object toggleActiveUser(Long id);

    Object updateRolesUser(UserAddRolesDTO dto);

    Object exportUser();

    Object importUser();

    Object changePassword(UserChangePasswordDTO dto);
}