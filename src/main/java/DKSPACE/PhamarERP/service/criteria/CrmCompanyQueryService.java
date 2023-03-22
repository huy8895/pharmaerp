package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmCompanyCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmCompany;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmCompany_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CrmCompanyQueryService extends QueryService<CrmCompany> implements FilterService<CrmCompany,CrmCompanyCriteria> {
	
	public Specification<CrmCompany> createSpecification(CrmCompanyCriteria criteria) {
		return SpecificationBuilder
				.<CrmCompany>builder()
				.and(criteria.getTaxCode(), filter -> this.buildStringSpecification(filter, CrmCompany_.taxCode))
				.and(criteria.getCompanyNameVi(), filter -> this.buildStringSpecification(filter, CrmCompany_.companyNameVi))
				.and(criteria.getCompanyNameEn(), filter -> this.buildStringSpecification(filter, CrmCompany_.companyNameEn))
				.and(criteria.getAbbreviationName(), filter -> this.buildStringSpecification(filter, CrmCompany_.abbreviationName))
				.and(criteria.getHeadquarter(), filter -> this.buildStringSpecification(filter, CrmCompany_.headquarter))
				.and(criteria.getMainTel(), filter -> this.buildStringSpecification(filter, CrmCompany_.mainTel))
				.and(criteria.getMainFax(), filter -> this.buildStringSpecification(filter, CrmCompany_.mainFax))
				.and(criteria.getMainEmail(), filter -> this.buildStringSpecification(filter, CrmCompany_.mainEmail))
				.and(criteria.getOperationDay(), filter -> this.buildRangeSpecification(filter, CrmCompany_.operationDay))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter, CrmCompany_.isActive))
				.build();
	}
}