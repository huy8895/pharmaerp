package DKSPACE.PhamarERP.user.repository;

import DKSPACE.PhamarERP.basecrud.BaseCRUDRepository;
import DKSPACE.PhamarERP.user.model.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserProfileRepository extends BaseCRUDRepository<UserProfile, Long> {
	@Query("select u from UserProfile u where u.user.id = :userId")
	Optional<UserProfile> findByUserId(@Param("userId") Long userId);
}