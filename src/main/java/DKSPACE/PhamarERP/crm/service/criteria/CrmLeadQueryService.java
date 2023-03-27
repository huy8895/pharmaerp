package DKSPACE.PhamarERP.crm.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.crm.criteria.CrmLeadCriteria;
import DKSPACE.PhamarERP.crm.model.CrmLead;
import DKSPACE.PhamarERP.crm.model.CrmLead_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CrmLeadQueryService extends FilterService<CrmLead, CrmLeadCriteria> {
	
	public Specification<CrmLead> createSpecification(CrmLeadCriteria criteria) {
		return SpecificationBuilder
				.<CrmLead>builder()
				.and(criteria.getName(), CrmLead_.name, super::buildStringSpecification)
				.and(criteria.getDescribe(), CrmLead_.describe, super::buildStringSpecification)
				.and(criteria.getIsActive(), CrmLead_.isActive, super::buildSpecification)
				.build();
	}
}