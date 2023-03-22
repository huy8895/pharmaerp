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
				.and(criteria.getTaxCode(), CrmCompany_.taxCode, super::buildStringSpecification)
				.and(criteria.getCompanyNameVi(), CrmCompany_.companyNameVi, super::buildStringSpecification)
				.and(criteria.getCompanyNameEn(), CrmCompany_.companyNameEn, super::buildStringSpecification)
				.and(criteria.getAbbreviationName(), CrmCompany_.abbreviationName, super::buildStringSpecification)
				.and(criteria.getHeadquarter(), CrmCompany_.headquarter, super::buildStringSpecification)
				.and(criteria.getMainTel(), CrmCompany_.mainTel, super::buildStringSpecification)
				.and(criteria.getMainFax(), CrmCompany_.mainFax, super::buildStringSpecification)
				.and(criteria.getMainEmail(), CrmCompany_.mainEmail, super::buildStringSpecification)
				.and(criteria.getOperationDay(), CrmCompany_.operationDay, super::buildRangeSpecification)
				.and(criteria.getIsActive(), CrmCompany_.isActive, super::buildSpecification)
				.build();
	}
}