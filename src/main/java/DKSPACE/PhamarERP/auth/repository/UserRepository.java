package DKSPACE.PhamarERP.auth.repository;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.model.User_;
import DKSPACE.PhamarERP.basecrud.BaseCRUDRepository;
import DKSPACE.PhamarERP.general.model.Uploadable_;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends BaseCRUDRepository<User, Long> {

    @Query("select u from User u where u.email = :email or u.username = :email")
    Optional<User> findByEmailOrUsername(@Param("email") String email);
	
	@Query("SELECT u FROM User u JOIN FETCH u.uploadables ub WHERE u.id = :userId AND ub.objectType = 'USER' and ub.objectField = 'AVATAR'")
	Optional<User> findUsersWithUploadables(@Param("userId") Long userId);
	
	static Specification<User> fetchAvatar(Long userId) {
		return (root, query, criteriaBuilder) -> {
			final var join = (Join<Object, Object>) root.fetch(User_.UPLOADABLES, JoinType.LEFT);
			query.distinct(true);
			Predicate id = criteriaBuilder.equal(root.get("id"), userId);
			return criteriaBuilder.and(
					id,
					criteriaBuilder.equal(join.get(Uploadable_.OBJECT_TYPE), "USER"),
					criteriaBuilder.equal(join.get(Uploadable_.OBJECT_FIELD), "AVATAR")
			);
		};
	}
	
}
