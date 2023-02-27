package DKSPACE.PhamarERP.auth.service;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.basecrud.BaseCRUDService;

public interface RoleService extends BaseCRUDService<Role> {
    Role createRole(Role role);
}