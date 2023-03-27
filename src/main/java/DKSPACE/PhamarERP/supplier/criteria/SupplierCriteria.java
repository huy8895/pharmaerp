package DKSPACE.PhamarERP.supplier.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.supplier.model.Supplier;
import DKSPACE.PhamarERP.supplier.model.Supplier_;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.StringFilter;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierCriteria extends BaseCrudCriteria<Supplier> {
	
	private StringFilter taxCode;
	private StringFilter companyNameVi;
	private StringFilter companyNameEn;
	private StringFilter abbreviationName;
	private StringFilter headquarter;
	private StringFilter companyCeo;
	private StringFilter mainTel;
	private StringFilter mainFax;
	private StringFilter mainEmail;
	private LocalDateFilter operationDay;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<Supplier, String>> searchBy() {
		return List.of(Supplier_.taxCode, Supplier_.companyNameVi, Supplier_.companyNameEn,
		               Supplier_.abbreviationName, Supplier_.headquarter, Supplier_.mainTel, Supplier_.mainFax,
		               Supplier_.mainEmail, Supplier_.companyCeo);
	}
}
