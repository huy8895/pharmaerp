package DKSPACE.PhamarERP.controller.csm;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmCompany;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmCompany_;
import DKSPACE.PhamarERP.repository.crm.CrmCompanyRepository;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrmCompanyQueryService extends QueryService<CrmCompany> implements FilterService<CrmCompanyCriteria> {
	private final CrmCompanyRepository repository;
	
	@Transactional(readOnly = true)
	public Page<CrmCompany> findByCriteria(CrmCompanyCriteria criteria, Pageable page) {
		log.debug("CrmCompanyQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<CrmCompany> specification = this.createSpecification(criteria);
		return repository.findAll(specification, page);
	}
	
	private Specification<CrmCompany> createSpecification(CrmCompanyCriteria criteria) {
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