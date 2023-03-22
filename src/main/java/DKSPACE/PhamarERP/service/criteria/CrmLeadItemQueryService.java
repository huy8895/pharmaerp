package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmLeadItemCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLeadItem;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLeadItem_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CrmLeadItemQueryService extends QueryService<CrmLeadItem> implements FilterService<CrmLeadItem,CrmLeadItemCriteria> {
	
	public Specification<CrmLeadItem> createSpecification(CrmLeadItemCriteria criteria) {
		return SpecificationBuilder
				.<CrmLeadItem>builder()
				.and(criteria.getCrmLeadId(), CrmLeadItem_.crmLeadId, super::buildSpecification)
				.and(criteria.getName(), CrmLeadItem_.name, super::buildStringSpecification)
				.and(criteria.getColor(), CrmLeadItem_.color, super::buildStringSpecification)
				.and(criteria.getDescribe(), CrmLeadItem_.describe, super::buildStringSpecification)
				.and(criteria.getIsActive(), CrmLeadItem_.isActive, super::buildSpecification)
				.build();
	}
}