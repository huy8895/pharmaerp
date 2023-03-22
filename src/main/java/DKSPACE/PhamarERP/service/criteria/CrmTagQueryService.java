package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmTagCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmTag;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmTag_;
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