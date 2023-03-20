package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCoursCriteria;
import DKSPACE.PhamarERP.master_data.entity.UserCours;
import DKSPACE.PhamarERP.master_data.entity.UserCours_;
import DKSPACE.PhamarERP.repository.UserCoursRepository;
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
public class UserCoursQueryService extends QueryService<UserCours> implements FilterService<UserCoursCriteria> {
	private final UserCoursRepository repository;
	
	@Transactional(readOnly = true)
	public Page<UserCours> findByCriteria(UserCoursCriteria criteria, Pageable page) {
		log.debug("UserCoursQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<UserCours> specification = this.createSpecification(criteria);
		return repository.findAll(specification, page);
	}
	
	private Specification<UserCours> createSpecification(UserCoursCriteria criteria) {
		return SpecificationBuilder
				.<UserCours>builder()
				.and(criteria.getUserId(), filter -> this.buildSpecification(filter, UserCours_.userId))
				.and(criteria.getName(), filter -> this.buildStringSpecification(filter, UserCours_.name))
				.and(criteria.getOrganization(), filter -> this.buildStringSpecification(filter, UserCours_.organization))
				.and(criteria.getStartDate(), filter -> this.buildStringSpecification(filter, UserCours_.startDate))
				.and(criteria.getEndDate(), filter -> this.buildStringSpecification(filter, UserCours_.endDate))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, UserCours_.describe))
				.and(criteria.getLink(), filter -> this.buildStringSpecification(filter, UserCours_.link))
				.build();
	}
}