package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenDepartmentCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenDepartment;
import DKSPACE.PhamarERP.master_data.entity.GenDepartment_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GenDepartmentQueryService extends QueryService<GenDepartment> implements FilterService<GenDepartment,GenDepartmentCriteria> {
	
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
