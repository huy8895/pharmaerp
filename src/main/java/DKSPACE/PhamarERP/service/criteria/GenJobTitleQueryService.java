package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenJobTitleCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenJobTitle;
import DKSPACE.PhamarERP.master_data.entity.GenJobTitle_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class GenJobTitleQueryService extends QueryService<GenJobTitle> implements FilterService<GenJobTitle,GenJobTitleCriteria> {
	public Specification<GenJobTitle> createSpecification(GenJobTitleCriteria criteria) {
		return SpecificationBuilder
				.<GenJobTitle>builder()
				.and(criteria.getNameVi(), filter -> this.buildStringSpecification(filter, GenJobTitle_.nameVi))
				.and(criteria.getNameEn(), filter -> this.buildStringSpecification(filter, GenJobTitle_.nameEn))
				.and(criteria.getSalary(), filter -> this.buildSpecification(filter, GenJobTitle_.salary))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, GenJobTitle_.describe))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter, GenJobTitle_.isActive))
				.build();
	}
}
