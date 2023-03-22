package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenOfficerLevelCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenOfficerLevel;
import DKSPACE.PhamarERP.master_data.entity.GenOfficerLevel_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class GenOfficerLevelQueryService extends QueryService<GenOfficerLevel> implements FilterService<GenOfficerLevel,GenOfficerLevelCriteria> {
	
	public Specification<GenOfficerLevel> createSpecification(GenOfficerLevelCriteria criteria) {
		return SpecificationBuilder
				.<GenOfficerLevel>builder()
				.and(criteria.getNameVi(), filter -> this.buildStringSpecification(filter, GenOfficerLevel_.nameVi))
				.and(criteria.getNameEn(), filter -> this.buildStringSpecification(filter, GenOfficerLevel_.nameEn))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, GenOfficerLevel_.describe))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter, GenOfficerLevel_.isActive))
				.build();
	}
	

}
