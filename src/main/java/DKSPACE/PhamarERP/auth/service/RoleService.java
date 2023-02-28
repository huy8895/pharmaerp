package DKSPACE.PhamarERP.auth.service;

import DKSPACE.PhamarERP.auth.dto.role.RoleCreateDTO;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.basecrud.BaseCRUDService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;

public interface RoleService extends BaseCRUDService<Role> {
    Role createRole(@Valid RoleCreateDTO role);

    Object listRoles(Pageable unpaged);
}