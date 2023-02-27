package DKSPACE.PhamarERP.auth.service;

import DKSPACE.PhamarERP.auth.dto.role.RoleDTO;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.basecrud.BaseCRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface RoleService extends BaseCRUDService<Role> {
    Role createRole(Role role);

    Object listRoles(Pageable unpaged);
}