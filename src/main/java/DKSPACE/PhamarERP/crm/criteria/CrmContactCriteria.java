package DKSPACE.PhamarERP.crm.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.crm.model.CrmContact;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrmContactCriteria extends BaseCrudCriteria<CrmContact> {
	private LongFilter crmCompanyId;
	private StringFilter email;
	private StringFilter tel;
	private StringFilter firstName;
	private StringFilter lastName;
	private StringFilter englishName;
	private StringFilter designation;
	private BooleanFilter isActive;
}