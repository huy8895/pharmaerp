package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCriteria;
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
		if (criteria.getEmail() != null){
//			this.buildStringSpecification(criteria.getEmail(), )
		}
		return null;
	}
}
