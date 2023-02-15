package DKSPACE.PhamarERP.auth.repository;

import DKSPACE.PhamarERP.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
