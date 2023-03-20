package DKSPACE.PhamarERP.controller.csm;

import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLead;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrmLeadCriteria implements Criteria<CrmLead> {
	private StringFilter name;
	private StringFilter describe;
	private BooleanFilter isActive;
}