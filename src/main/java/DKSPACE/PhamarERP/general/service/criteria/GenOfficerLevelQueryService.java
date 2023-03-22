package DKSPACE.PhamarERP.general.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.QueryService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.general.criteria.GenOfficerLevelCriteria;
import DKSPACE.PhamarERP.general.model.GenOfficerLevel;
import DKSPACE.PhamarERP.general.model.GenOfficerLevel_;
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
