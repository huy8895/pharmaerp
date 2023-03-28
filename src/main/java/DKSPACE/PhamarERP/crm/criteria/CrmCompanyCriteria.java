package DKSPACE.PhamarERP.crm.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.crm.model.CrmCompany;
import DKSPACE.PhamarERP.crm.model.CrmCompany_;
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
public class CrmCompanyCriteria extends BaseCrudCriteria<CrmCompany> {
	private StringFilter taxCode;
	private StringFilter companyNameVi;
	private StringFilter companyNameEn;
	private StringFilter abbreviationName;
	private StringFilter headquarter;
	private StringFilter mainTel;
	private StringFilter mainFax;
	private StringFilter mainEmail;
	private LocalDateFilter operationDay;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<CrmCompany, String>> searchBy() {
		return List.of(CrmCompany_.taxCode, CrmCompany_.companyNameVi, CrmCompany_.companyNameEn,
		               CrmCompany_.abbreviationName, CrmCompany_.headquarter, CrmCompany_.mainTel, CrmCompany_.mainFax,
		               CrmCompany_.mainEmail);
	}
}
