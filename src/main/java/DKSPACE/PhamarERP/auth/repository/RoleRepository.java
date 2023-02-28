package DKSPACE.PhamarERP.auth.repository;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.basecrud.BaseCRUDRepository;

import java.util.Set;

public interface RoleRepository extends BaseCRUDRepository<Role, Long> {

    Set<Role> findAllByNameEn(String roleName);

}

