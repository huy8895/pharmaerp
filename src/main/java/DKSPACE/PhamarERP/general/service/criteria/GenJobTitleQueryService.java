package DKSPACE.PhamarERP.general.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseFilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.general.criteria.GenJobTitleCriteria;
import DKSPACE.PhamarERP.general.model.GenJobTitle;
import DKSPACE.PhamarERP.general.model.GenJobTitle_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GenJobTitleQueryService extends BaseFilterService<GenJobTitle,GenJobTitleCriteria> {
	public Specification<GenJobTitle> createSpecification(GenJobTitleCriteria criteria) {
		return SpecificationBuilder
				.<GenJobTitle>builder()
				.and(criteria.getNameVi(), GenJobTitle_.nameVi, super::buildStringSpecification)
				.and(criteria.getNameEn(), GenJobTitle_.nameEn, super::buildStringSpecification)
				.and(criteria.getSalary(), GenJobTitle_.salary, super::buildSpecification)
				.and(criteria.getDescribe(), GenJobTitle_.describe, super::buildStringSpecification)
				.and(criteria.getIsActive(), GenJobTitle_.isActive, super::buildSpecification)
				.build();
	}
}
