package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmContactCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmContact;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmContact_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CrmContactQueryService extends QueryService<CrmContact> implements FilterService<CrmContact,CrmContactCriteria> {
	
	public Specification<CrmContact> createSpecification(CrmContactCriteria criteria) {
		return SpecificationBuilder
				.<CrmContact>builder()
				.and(criteria.getCrmCompanyId(), filter -> this.buildSpecification(filter, CrmContact_.crmCompanyId))
				.and(criteria.getEmail(), filter -> this.buildStringSpecification(filter, CrmContact_.email))
				.and(criteria.getTel(), filter -> this.buildStringSpecification(filter, CrmContact_.tel))
				.and(criteria.getFirstName(), filter -> this.buildStringSpecification(filter, CrmContact_.firstName))
				.and(criteria.getLastName(), filter -> this.buildStringSpecification(filter, CrmContact_.lastName))
				.and(criteria.getEnglishName(), filter -> this.buildStringSpecification(filter, CrmContact_.englishName))
				.and(criteria.getDesignation(), filter -> this.buildStringSpecification(filter,CrmContact_.designation))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter,CrmContact_.isActive))
				.build();
	}
}