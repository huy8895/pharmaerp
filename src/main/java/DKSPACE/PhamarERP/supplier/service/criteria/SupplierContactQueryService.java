package DKSPACE.PhamarERP.supplier.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.supplier.criteria.SupplierContactCriteria;
import DKSPACE.PhamarERP.supplier.model.SupplierContact;
import DKSPACE.PhamarERP.supplier.model.SupplierContact_;
import DKSPACE.PhamarERP.supplier.model.Supplier_;
import jakarta.persistence.criteria.JoinType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SupplierContactQueryService extends FilterService<SupplierContact, SupplierContactCriteria> {
	
	public Specification<SupplierContact> createSpecification(SupplierContactCriteria criteria) {
		return SpecificationBuilder.<SupplierContact>builder()
		                           .and(criteria.getSupplierId(),
		                                root -> root.join(SupplierContact_.supplier, JoinType.LEFT).get(Supplier_.id),
		                                super::buildRangeSpecification)
		                           .and(criteria.getEmail(), SupplierContact_.email, super::buildStringSpecification)
		                           .and(criteria.getTel(), SupplierContact_.tel, super::buildStringSpecification)
		                           .and(criteria.getFirstName(), SupplierContact_.firstName, super::buildStringSpecification)
		                           .and(criteria.getLastName(), SupplierContact_.lastName, super::buildStringSpecification)
		                           .and(criteria.getEnglishName(), SupplierContact_.englishName, super::buildStringSpecification)
		                           .and(criteria.getDesignation(), SupplierContact_.designation, super::buildStringSpecification)
		                           .and(criteria.getIsActive(), SupplierContact_.isActive, super::buildSpecification)
		                           .build();
	}
}