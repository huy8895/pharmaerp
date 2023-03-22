package DKSPACE.PhamarERP.user.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.QueryService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.user.dto.criteria.UserActivityCriteria;
import DKSPACE.PhamarERP.user.model.UserActivity;
import DKSPACE.PhamarERP.user.model.UserActivity_;
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
				.and(criteria.getUserId(), UserActivity_.userId, super::buildSpecification)
				.and(criteria.getOrganization(), UserActivity_.organization, super::buildStringSpecification)
				.and(criteria.getParticipatingPosition(), UserActivity_.participatingPosition, super::buildStringSpecification)
				.and(criteria.getIsCurrentActive(), UserActivity_.isCurrentActive, super::buildSpecification)
				.and(criteria.getStartDate(), UserActivity_.startDate, super::buildStringSpecification)
				.and(criteria.getEndDate(), UserActivity_.endDate, super::buildStringSpecification)
				.and(criteria.getDescribe(), UserActivity_.describe, super::buildStringSpecification)
				.and(criteria.getLink(), UserActivity_.link, super::buildStringSpecification)
				.build();
	}
}