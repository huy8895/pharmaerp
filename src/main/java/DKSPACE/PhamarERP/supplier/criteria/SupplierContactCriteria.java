package DKSPACE.PhamarERP.supplier.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.supplier.model.SupplierContact;
import DKSPACE.PhamarERP.supplier.model.SupplierContact_;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierContactCriteria extends BaseCrudCriteria<SupplierContact> {
	
	private LongFilter supplierId;
	private StringFilter email;
	private StringFilter tel;
	private StringFilter firstName;
	private StringFilter lastName;
	private StringFilter englishName;
	private StringFilter designation;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<SupplierContact, String>> searchBy() {
		return List.of(SupplierContact_.email, SupplierContact_.tel, SupplierContact_.firstName,
		               SupplierContact_.lastName, SupplierContact_.englishName, SupplierContact_.designation);
	}
}
