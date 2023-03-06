package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.auth.model.Role_;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.model.User_;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCriteria;
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
		Specification<User> specification = Specification.where(null);
		
		if (criteria.getSearch() != null){
			specification =
					specification.and(this.buildStringSpecification(criteria.getSearch(), User_.phoneNumber)
					                      .or(this.buildStringSpecification(criteria.getSearch(), User_.email))
					                      .or(this.buildStringSpecification(criteria.getSearch(), User_.username))
					                      .or(this.buildStringSpecification(criteria.getSearch(), User_.staffCode))
					                      .or(this.buildStringSpecification(criteria.getSearch(), User_.firstName))
					                      .or(this.buildStringSpecification(criteria.getSearch(), User_.lastName))
					);
		}
		
		if (criteria.getType() != null){
			specification = specification.and(this.buildSpecification(criteria.getType(), User_.type));
		}
		
		if (criteria.getRoleId() != null){
			specification = specification.and(this.buildSpecification(criteria.getRoleId(), userRoot -> userRoot.join(User_.roles, JoinType.LEFT).get(
					Role_.id)));
		}
		
		if (criteria.getIsActive() != null){
			specification = specification.and(this.buildSpecification(criteria.getIsActive(), User_.isActive));
		}
		
		return specification;
	}
}
