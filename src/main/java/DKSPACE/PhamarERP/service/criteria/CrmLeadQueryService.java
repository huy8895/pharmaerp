package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmLeadCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLead;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLead_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CrmLeadQueryService extends QueryService<CrmLead> implements FilterService<CrmLead,CrmLeadCriteria> {
	
	public Specification<CrmLead> createSpecification(CrmLeadCriteria criteria) {
		return SpecificationBuilder
				.<CrmLead>builder()
				.and(criteria.getName(), filter -> this.buildStringSpecification(filter, CrmLead_.name))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, CrmLead_.describe))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter, CrmLead_.isActive))
				.build();
	}
}