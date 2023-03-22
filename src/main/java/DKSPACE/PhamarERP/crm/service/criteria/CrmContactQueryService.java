package DKSPACE.PhamarERP.crm.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.QueryService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.crm.criteria.CrmContactCriteria;
import DKSPACE.PhamarERP.crm.model.CrmContact;
import DKSPACE.PhamarERP.crm.model.CrmContact_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CrmContactQueryService extends QueryService<CrmContact> implements FilterService<CrmContact,CrmContactCriteria> {
	
	public Specification<CrmContact> createSpecification(CrmContactCriteria criteria) {
		return SpecificationBuilder
				.<CrmContact>builder()
				.and(criteria.getCrmCompanyId(), CrmContact_.crmCompanyId, super::buildSpecification)
				.and(criteria.getEmail(), CrmContact_.email, super::buildStringSpecification)
				.and(criteria.getTel(), CrmContact_.tel, super::buildStringSpecification)
				.and(criteria.getFirstName(), CrmContact_.firstName, super::buildStringSpecification)
				.and(criteria.getLastName(), CrmContact_.lastName, super::buildStringSpecification)
				.and(criteria.getEnglishName(), CrmContact_.englishName, super::buildStringSpecification)
				.and(criteria.getDesignation(), CrmContact_.designation, super::buildStringSpecification)
				.and(criteria.getIsActive(), CrmContact_.isActive, super::buildSpecification)
				.build();
	}
}