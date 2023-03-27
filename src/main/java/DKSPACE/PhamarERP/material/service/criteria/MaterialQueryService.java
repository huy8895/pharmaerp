package DKSPACE.PhamarERP.material.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.material.criteria.MaterialCriteria;
import DKSPACE.PhamarERP.material.model.GenUnit_;
import DKSPACE.PhamarERP.material.model.Material;
import DKSPACE.PhamarERP.material.model.MaterialGroup_;
import DKSPACE.PhamarERP.material.model.Material_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MaterialQueryService extends FilterService<Material, MaterialCriteria> {
	
	public Specification<Material> createSpecification(MaterialCriteria criteria) {
		return SpecificationBuilder
				.<Material>builder()
				.and(criteria.getGenUnitId(), root -> root.join(Material_.genUnit).get(GenUnit_.id),
				     super::buildSpecification)
				.and(criteria.getMaterialGroupId(), root -> root.join(Material_.materialGroup).get(MaterialGroup_.id),
				     super::buildSpecification)
				.and(criteria.getNameVi(), Material_.nameVi, super::buildStringSpecification)
				.and(criteria.getNameEn(), Material_.nameEn, super::buildStringSpecification)
				.and(criteria.getNameScience(), Material_.nameScience, super::buildStringSpecification)
				.and(criteria.getNameOther(), Material_.nameOther, super::buildStringSpecification)
				.and(criteria.getInventoryMin(), Material_.inventoryMin, super::buildRangeSpecification)
				.and(criteria.getInventoryMax(), Material_.inventoryMax, super::buildRangeSpecification)
				.and(criteria.getDescribe(), Material_.describe, super::buildStringSpecification)
				.and(criteria.getIsActive(), Material_.isActive, super::buildSpecification)
				.build();
	}
}