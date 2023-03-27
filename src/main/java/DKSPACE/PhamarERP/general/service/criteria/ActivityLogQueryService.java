package DKSPACE.PhamarERP.general.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.general.criteria.ActivityLogCriteria;
import DKSPACE.PhamarERP.general.model.ActivityLog;
import DKSPACE.PhamarERP.general.model.ActivityLog_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ActivityLogQueryService extends FilterService<ActivityLog, ActivityLogCriteria> {
	
	public Specification<ActivityLog> createSpecification(ActivityLogCriteria criteria) {
		return SpecificationBuilder
				.<ActivityLog>builder()
				.and(criteria.getUserId(), ActivityLog_.userId, super::buildSpecification)
				.and(criteria.getIp(), ActivityLog_.ip, super::buildStringSpecification)
				.and(criteria.getUserAgent(), ActivityLog_.userAgent, super::buildStringSpecification)
				.and(criteria.getRequest(), ActivityLog_.request, super::buildStringSpecification)
				.and(criteria.getResponse(), ActivityLog_.response, super::buildStringSpecification)
				.build();
	}
}
