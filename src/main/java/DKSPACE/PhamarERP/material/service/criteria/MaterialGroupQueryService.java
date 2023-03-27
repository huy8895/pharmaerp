package DKSPACE.PhamarERP.material.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.material.criteria.MaterialGroupCriteria;
import DKSPACE.PhamarERP.material.model.MaterialGroup;
import DKSPACE.PhamarERP.material.model.MaterialGroup_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MaterialGroupQueryService extends FilterService<MaterialGroup, MaterialGroupCriteria> {
	
	public Specification<MaterialGroup> createSpecification(MaterialGroupCriteria criteria) {
		return SpecificationBuilder
				.<MaterialGroup>builder()
				.and(criteria.getNameVi(), MaterialGroup_.nameVi, super::buildStringSpecification)
				.and(criteria.getNameEn(), MaterialGroup_.nameEn, super::buildStringSpecification)
				.and(criteria.getType(), MaterialGroup_.type, super::buildStringSpecification)
				.and(criteria.getIsActive(), MaterialGroup_.isActive, super::buildSpecification)
				.build();
	}
}