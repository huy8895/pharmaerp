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
				.and(criteria.getNameVi(), GenOfficerLevel_.nameVi, super::buildStringSpecification)
				.and(criteria.getNameEn(), GenOfficerLevel_.nameEn, super::buildStringSpecification)
				.and(criteria.getDescribe(), GenOfficerLevel_.describe, super::buildStringSpecification)
				.and(criteria.getIsActive(), GenOfficerLevel_.isActive, super::buildSpecification)
				.build();
	}
	

}
