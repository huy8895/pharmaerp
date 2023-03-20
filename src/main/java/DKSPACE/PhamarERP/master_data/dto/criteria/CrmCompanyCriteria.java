package DKSPACE.PhamarERP.master_data.dto.criteria;

import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmCompany;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrmCompanyCriteria implements Criteria<CrmCompany> {
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
}