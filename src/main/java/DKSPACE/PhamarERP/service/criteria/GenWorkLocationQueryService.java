package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenWorkLocationCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenWorkLocation;
import DKSPACE.PhamarERP.master_data.entity.GenWorkLocation_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GenWorkLocationQueryService extends QueryService<GenWorkLocation> implements FilterService<GenWorkLocation,GenWorkLocationCriteria> {
	
	public Specification<GenWorkLocation> createSpecification(GenWorkLocationCriteria criteria) {
		return SpecificationBuilder
				.<GenWorkLocation>builder()
				.and(criteria.getNameVi(), GenWorkLocation_.nameVi, super::buildStringSpecification)
				.and(criteria.getNameEn(), GenWorkLocation_.nameEn, super::buildStringSpecification)
				.and(criteria.getDescribe(), GenWorkLocation_.describe, super::buildStringSpecification)
				.and(criteria.getIsActive(), GenWorkLocation_.isActive, super::buildSpecification)
				.build();
	}
}