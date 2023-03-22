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
				.and(criteria.getNameVi(), filter -> this.buildStringSpecification(filter, GenWorkLocation_.nameVi))
				.and(criteria.getNameEn(), filter -> this.buildStringSpecification(filter, GenWorkLocation_.nameEn))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, GenWorkLocation_.describe))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter, GenWorkLocation_.isActive))
				.build();
	}
}