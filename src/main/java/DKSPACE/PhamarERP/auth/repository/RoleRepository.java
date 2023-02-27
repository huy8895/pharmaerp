package DKSPACE.PhamarERP.auth.repository;

import DKSPACE.PhamarERP.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Set<Role> findAllByName(String roleName);
}

