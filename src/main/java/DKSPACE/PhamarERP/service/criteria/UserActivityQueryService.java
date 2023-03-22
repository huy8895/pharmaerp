package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserActivityCriteria;
import DKSPACE.PhamarERP.master_data.entity.UserActivity;
import DKSPACE.PhamarERP.master_data.entity.UserActivity_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class UserActivityQueryService extends QueryService<UserActivity>
		implements FilterService<UserActivity, UserActivityCriteria> {
	
	public Specification<UserActivity> createSpecification(UserActivityCriteria criteria) {
		return SpecificationBuilder
				.<UserActivity>builder()
				.and(criteria.getUserId(), filter -> this.buildSpecification(filter, UserActivity_.userId))
				.and(criteria.getOrganization(),
				     filter -> this.buildStringSpecification(filter, UserActivity_.organization))
				.and(criteria.getParticipatingPosition(),
				     filter -> this.buildStringSpecification(filter, UserActivity_.participatingPosition))
				.and(criteria.getIsCurrentActive(),
				     filter -> this.buildSpecification(filter, UserActivity_.isCurrentActive))
				.and(criteria.getStartDate(), filter -> this.buildStringSpecification(filter, UserActivity_.startDate))
				.and(criteria.getEndDate(), filter -> this.buildStringSpecification(filter, UserActivity_.endDate))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, UserActivity_.describe))
				.and(criteria.getLink(), filter -> this.buildStringSpecification(filter, UserActivity_.link))
				.build();
	}
}