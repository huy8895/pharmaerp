package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.auth.model.Role_;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.model.User_;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCriteria;
import io.github.jhipster.service.filter.StringFilter;
import jakarta.persistence.criteria.JoinType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserQueryService extends QueryService<User> {
	private final UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public Page<User> findByCriteria(UserCriteria criteria, Pageable page) {
		log.debug("UserQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<User> specification = this.createSpecification(criteria);
		return userRepository.findAll(specification, page);
	}
	
	private Specification<User> createSpecification(UserCriteria criteria) {
		return SpecificationBuilder
				.<User>builder()
				.and(criteria.getSearch(),
				     filter -> this.buildStringSpecification((StringFilter) filter, User_.phoneNumber)
				                   .or(this.buildStringSpecification((StringFilter) filter, User_.email))
				                   .or(this.buildStringSpecification((StringFilter) filter, User_.username))
				                   .or(this.buildStringSpecification((StringFilter) filter, User_.staffCode))
				                   .or(this.buildStringSpecification((StringFilter) filter, User_.firstName))
				                   .or(this.buildStringSpecification((StringFilter) filter, User_.lastName)))
				.and(criteria.getType(),
				     filter -> this.buildSpecification(filter, User_.type))
				.and(criteria.getRoleId(),
				     longFilter -> this.buildSpecification(longFilter,
				                                           userRoot -> userRoot.join(User_.roles, JoinType.LEFT).get(
						                                           Role_.id)))
				.and(criteria.getIsActive(),
				     booleanFilter -> this.buildSpecification(booleanFilter, User_.isActive))
				.build();
	}
}
