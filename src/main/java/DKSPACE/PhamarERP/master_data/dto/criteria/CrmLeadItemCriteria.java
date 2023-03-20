package DKSPACE.PhamarERP.master_data.dto.criteria;

import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLeadItem;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrmLeadItemCriteria implements Criteria<CrmLeadItem> {
	private LongFilter crmLeadId;
	private StringFilter name;
	private StringFilter color;
	private StringFilter describe;
	private BooleanFilter isActive;
}