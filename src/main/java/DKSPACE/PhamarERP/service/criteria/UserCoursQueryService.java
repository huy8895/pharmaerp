package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCoursCriteria;
import DKSPACE.PhamarERP.master_data.entity.UserCours;
import DKSPACE.PhamarERP.master_data.entity.UserCours_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class UserCoursQueryService extends QueryService<UserCours> implements FilterService<UserCours,UserCoursCriteria> {
	public Specification<UserCours> createSpecification(UserCoursCriteria criteria) {
		return SpecificationBuilder
				.<UserCours>builder()
				.and(criteria.getUserId(), UserCours_.userId, super::buildSpecification)
				.and(criteria.getName(), UserCours_.name, super::buildStringSpecification)
				.and(criteria.getOrganization(), UserCours_.organization, super::buildStringSpecification)
				.and(criteria.getStartDate(), UserCours_.startDate, super::buildStringSpecification)
				.and(criteria.getEndDate(), UserCours_.endDate, super::buildStringSpecification)
				.and(criteria.getDescribe(), UserCours_.describe, super::buildStringSpecification)
				.and(criteria.getLink(), UserCours_.link, super::buildStringSpecification)
				.build();
	}
}