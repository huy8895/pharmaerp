package DKSPACE.PhamarERP.auth.service;

import DKSPACE.PhamarERP.auth.dto.role.RoleCreateDTO;
import DKSPACE.PhamarERP.auth.dto.role.RoleCriteria;
import DKSPACE.PhamarERP.auth.dto.role.RoleDTO;
import DKSPACE.PhamarERP.auth.dto.role.RoleUpdateDTO;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.basecrud.BaseCRUDService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService extends BaseCRUDService<Role> {
    RoleDTO createRole(@Valid RoleCreateDTO role);
    
    Page<RoleDTO> listRoles(Pageable unpaged, RoleCriteria criteria);

    RoleDTO detailRole(Long id);

    void deleteRole(Long id);

    RoleDTO updateRole(@Valid RoleUpdateDTO role);
}