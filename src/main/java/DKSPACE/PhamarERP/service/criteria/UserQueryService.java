package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.auth.model.Role_;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.model.User_;
import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCriteria;
import jakarta.persistence.criteria.JoinType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserQueryService extends QueryService<User>
		implements FilterService<User, UserCriteria> {
	
	public Specification<User> createSpecification(UserCriteria criteria) {
		return SpecificationBuilder
				.<User>builder()
				.and(criteria.getPhoneNumber(), filter -> this.buildStringSpecification(filter, User_.phoneNumber))
				.and(criteria.getEmail(), filter -> this.buildStringSpecification(filter, User_.email))
				.and(criteria.getUsername(), filter -> this.buildStringSpecification(filter, User_.username))
				.and(criteria.getStaffCode(), filter -> this.buildStringSpecification(filter, User_.staffCode))
				.and(criteria.getFirstName(), filter -> this.buildStringSpecification(filter, User_.firstName))
				.and(criteria.getLastName(), filter -> this.buildStringSpecification(filter, User_.lastName))
				.and(criteria.getType(), userTypeFilter -> this.buildSpecification(userTypeFilter, User_.type))
				.and(criteria.getRoleId(), longFilter -> this.buildSpecification(longFilter,
				                                           userRoot -> userRoot.join(User_.roles, JoinType.LEFT).get(Role_.id)))
				.and(criteria.getIsActive(),
				     booleanFilter -> this.buildSpecification(booleanFilter, User_.isActive))
				.build();
	}
}
