package DKSPACE.PhamarERP.general.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseFilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.general.criteria.GenDepartmentCriteria;
import DKSPACE.PhamarERP.general.model.GenDepartment;
import DKSPACE.PhamarERP.general.model.GenDepartment_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GenDepartmentQueryService extends BaseFilterService<GenDepartment,GenDepartmentCriteria> {
	
	public Specification<GenDepartment> createSpecification(GenDepartmentCriteria criteria) {
		return SpecificationBuilder
				.<GenDepartment>builder()
				.and(criteria.getNameVi(), GenDepartment_.nameVi, super::buildStringSpecification)
				.and(criteria.getNameEn(), GenDepartment_.nameEn, super::buildStringSpecification)
				.and(criteria.getDescribe(), GenDepartment_.describe, super::buildStringSpecification)
				.and(criteria.getIsActive(), GenDepartment_.isActive, super::buildSpecification)
				.build();
	}
}
