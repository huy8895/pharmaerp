package DKSPACE.PhamarERP.supplier.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.supplier.criteria.SupplierCriteria;
import DKSPACE.PhamarERP.supplier.model.Supplier;
import DKSPACE.PhamarERP.supplier.model.Supplier_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SupplierQueryService extends FilterService<Supplier, SupplierCriteria> {
	@Override
	public Specification<Supplier> createSpecification(SupplierCriteria criteria) {
		return SpecificationBuilder.<Supplier>builder()
		                           .and(criteria.getTaxCode(), Supplier_.taxCode, super::buildStringSpecification)
		                           .and(criteria.getCompanyNameVi(), Supplier_.companyNameVi, super::buildStringSpecification)
		                           .and(criteria.getCompanyNameEn(), Supplier_.companyNameEn, super::buildStringSpecification)
		                           .and(criteria.getCompanyCeo(), Supplier_.companyCeo, super::buildStringSpecification)
		                           .and(criteria.getAbbreviationName(), Supplier_.abbreviationName, super::buildStringSpecification)
		                           .and(criteria.getHeadquarter(), Supplier_.headquarter, super::buildStringSpecification)
		                           .and(criteria.getMainTel(), Supplier_.mainTel, super::buildStringSpecification)
		                           .and(criteria.getMainFax(), Supplier_.mainFax, super::buildStringSpecification)
		                           .and(criteria.getMainEmail(), Supplier_.mainEmail, super::buildStringSpecification)
		                           .and(criteria.getOperationDay(), Supplier_.operationDay, super::buildRangeSpecification)
		                           .and(criteria.getIsActive(), Supplier_.isActive, super::buildSpecification)
		                           .build();
	}
}