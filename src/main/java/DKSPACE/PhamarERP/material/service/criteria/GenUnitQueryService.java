package DKSPACE.PhamarERP.material.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.material.criteria.GenUnitCriteria;
import DKSPACE.PhamarERP.material.model.GenUnit;
import DKSPACE.PhamarERP.material.model.GenUnit_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GenUnitQueryService extends FilterService<GenUnit, GenUnitCriteria> {
	
	public Specification<GenUnit> createSpecification(GenUnitCriteria criteria) {
		return SpecificationBuilder
				.<GenUnit>builder()
				.and(criteria.getNameVi(), GenUnit_.nameVi, super::buildStringSpecification)
				.and(criteria.getNameEn(), GenUnit_.nameEn, super::buildStringSpecification)
				.and(criteria.getIsActive(), GenUnit_.isActive, super::buildSpecification)
				.build();
	}
}