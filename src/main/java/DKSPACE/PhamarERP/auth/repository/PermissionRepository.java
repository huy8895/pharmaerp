package DKSPACE.PhamarERP.auth.repository;

import DKSPACE.PhamarERP.auth.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}

