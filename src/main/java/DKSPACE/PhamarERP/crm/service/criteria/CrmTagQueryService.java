package DKSPACE.PhamarERP.crm.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.QueryService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.crm.criteria.CrmTagCriteria;
import DKSPACE.PhamarERP.crm.model.CrmTag;
import DKSPACE.PhamarERP.crm.model.CrmTag_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CrmTagQueryService extends QueryService<CrmTag> implements FilterService<CrmTag,CrmTagCriteria> {
	public Specification<CrmTag> createSpecification(CrmTagCriteria criteria) {
		return SpecificationBuilder
				.<CrmTag>builder()
				.and(criteria.getName(), CrmTag_.name, super::buildStringSpecification)
				.and(criteria.getIsActive(), CrmTag_.isActive, super::buildSpecification)
				.build();
	}
}