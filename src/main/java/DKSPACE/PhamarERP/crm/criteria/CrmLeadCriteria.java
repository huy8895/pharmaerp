package DKSPACE.PhamarERP.crm.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.crm.model.CrmLead;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrmLeadCriteria extends BaseCrudCriteria<CrmLead> {
	private StringFilter name;
	private StringFilter describe;
	private BooleanFilter isActive;
}