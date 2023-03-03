package DKSPACE.PhamarERP.service;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.BaseCRUDService;
import DKSPACE.PhamarERP.master_data.dto.user.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface UserService extends BaseCRUDService<User> {
    Object listUser(Pageable pageable);

    Object createUser(UserCreateDTO dto);

    Object updateUser(UserUpdateDTO dto);

    Object toggleActiveUser(Long id);

    Object updateRolesUser(UserAddRolesDTO dto);

    Object exportUser();

    Object importUser(MultipartFile file);

    Object changePassword(UserChangePasswordDTO dto);
    
    Object exportTemplate();
    
    Object saveListUser(UserCreateListDTO dtos);
}