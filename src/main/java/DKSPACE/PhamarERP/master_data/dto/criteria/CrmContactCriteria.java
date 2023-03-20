package DKSPACE.PhamarERP.master_data.dto.criteria;

import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmContact;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrmContactCriteria implements Criteria<CrmContact> {
	private LongFilter crmCompanyId;
	private StringFilter email;
	private StringFilter tel;
	private StringFilter firstName;
	private StringFilter lastName;
	private StringFilter englishName;
	private StringFilter designation;
	private BooleanFilter isActive;
}