package DKSPACE.PhamarERP.crm.service.criteria;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity_;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.crm.criteria.CrmLeadItemCriteria;
import DKSPACE.PhamarERP.crm.model.CrmLeadItem;
import DKSPACE.PhamarERP.crm.model.CrmLeadItem_;
import jakarta.persistence.criteria.JoinType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CrmLeadItemQueryService extends FilterService<CrmLeadItem, CrmLeadItemCriteria> {
	
	public Specification<CrmLeadItem> createSpecification(CrmLeadItemCriteria criteria) {
		return SpecificationBuilder
				.<CrmLeadItem>builder()
				.and(criteria.getCrmLeadId(), root -> root.join(CrmLeadItem_.crmLead, JoinType.LEFT)
				                                          .get(BaseCRUDEntity_.id), super::buildSpecification)
				.and(criteria.getName(), CrmLeadItem_.name, super::buildStringSpecification)
				.and(criteria.getColor(), CrmLeadItem_.color, super::buildStringSpecification)
				.and(criteria.getDescribe(), CrmLeadItem_.describe, super::buildStringSpecification)
				.and(criteria.getIsActive(), CrmLeadItem_.isActive, super::buildSpecification)
				.build();
	}
}