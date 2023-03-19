package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.ActivityLogCriteria;
import DKSPACE.PhamarERP.master_data.entity.ActivityLog;
import DKSPACE.PhamarERP.master_data.entity.ActivityLog_;
import DKSPACE.PhamarERP.repository.ActivityLogRepository;
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
public class ActivityLogQueryService extends QueryService<ActivityLog>
		implements FilterService<ActivityLogCriteria>{
	private final ActivityLogRepository activityLogRepository;
	
	@Transactional(readOnly = true)
	public Page<ActivityLog> findByCriteria(ActivityLogCriteria criteria, Pageable page) {
		log.debug("ActivityLogQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<ActivityLog> specification = this.createSpecification(criteria);
		return activityLogRepository.findAll(specification, page);
	}
	
	private Specification<ActivityLog> createSpecification(ActivityLogCriteria criteria) {
		return SpecificationBuilder
				.<ActivityLog>builder()
				.and(criteria.getUserId(), filter -> this.buildSpecification(filter, ActivityLog_.userId))
				.and(criteria.getIp(), filter -> this.buildStringSpecification(filter, ActivityLog_.ip))
				.and(criteria.getUserAgent(), filter -> this.buildStringSpecification(filter, ActivityLog_.userAgent))
				.and(criteria.getRequest(), filter -> this.buildStringSpecification(filter, ActivityLog_.request))
				.and(criteria.getResponse(), filter -> this.buildStringSpecification(filter, ActivityLog_.response))
				.build();
	}
}
