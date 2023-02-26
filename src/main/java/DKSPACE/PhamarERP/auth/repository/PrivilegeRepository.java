package DKSPACE.PhamarERP.auth.repository;

import DKSPACE.PhamarERP.auth.model.Privilege;
import DKSPACE.PhamarERP.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

}
