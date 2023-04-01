package DKSPACE.PhamarERP.user.service.criteria;

import DKSPACE.PhamarERP.auth.model.Role_;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.model.User_;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.user.dto.criteria.UserCriteria;
import jakarta.persistence.criteria.JoinType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserQueryService extends FilterService<User, UserCriteria> {
	
	public Specification<User> createSpecification(UserCriteria criteria) {
		return SpecificationBuilder
				.<User>builder()
				.and(criteria.getPhoneNumber(), User_.phoneNumber, super::buildStringSpecification)
				.and(criteria.getEmail(), User_.email, super::buildStringSpecification)
				.and(criteria.getUsername(), User_.username, super::buildStringSpecification)
				.and(criteria.getStaffCode(), User_.staffCode, super::buildStringSpecification)
				.and(criteria.getFirstName(), User_.firstName, super::buildStringSpecification)
				.and(criteria.getLastName(), User_.lastName, super::buildStringSpecification)
				.and(criteria.getType(), User_.type, super::buildSpecification)
				.and(criteria.getRoleId(), root -> root.join(User_.roles, JoinType.LEFT).get(Role_.id),
				     super::buildRangeSpecification)
				.and(criteria.getIsActive(), User_.isActive, super::buildSpecification)
				.and(UserRepository.fetchAvatar())
				.build();
	}
	
}
