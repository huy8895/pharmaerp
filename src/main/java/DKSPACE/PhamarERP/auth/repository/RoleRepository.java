package DKSPACE.PhamarERP.auth.repository;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.BaseCRUDRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface RoleRepository extends BaseCRUDRepository<Role, Long> {

    Set<Role> findAllByNameEn(String roleName);

    @Query("select (count(r) > 0) from Role r join UsersRole ur on ur.role = r where r.id = :roleId")
    boolean existsByRoleIdJoinUsersRole(@Param("roleId") Long roleId);
}

