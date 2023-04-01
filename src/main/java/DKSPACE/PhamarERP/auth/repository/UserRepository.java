package DKSPACE.PhamarERP.auth.repository;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.BaseCRUDRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends BaseCRUDRepository<User, Long> {

    @Query("select u from User u where u.email = :email or u.username = :email")
    Optional<User> findByEmailOrUsername(@Param("email") String email);
	
	@Query("SELECT u FROM User u JOIN FETCH u.uploadables ub WHERE u.id = :userId AND ub.objectType = 'USER'")
	Optional<User> findUsersWithUploadables(@Param("userId") Long userId);
	

	
}
