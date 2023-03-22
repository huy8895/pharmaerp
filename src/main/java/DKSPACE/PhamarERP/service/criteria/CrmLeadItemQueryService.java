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
				.and(criteria.getCrmLeadId(), filter -> this.buildSpecification(filter, CrmLeadItem_.crmLeadId))
				.and(criteria.getName(), filter -> this.buildStringSpecification(filter, CrmLeadItem_.name))
				.and(criteria.getColor(), filter -> this.buildStringSpecification(filter, CrmLeadItem_.color))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter,CrmLeadItem_.describe))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter,CrmLeadItem_.isActive))
				.build();
	}
}