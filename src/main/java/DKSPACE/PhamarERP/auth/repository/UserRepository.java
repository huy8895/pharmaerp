package DKSPACE.PhamarERP.auth.repository;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.BaseCRUDRepository;

import java.util.Optional;

public interface UserRepository extends BaseCRUDRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
