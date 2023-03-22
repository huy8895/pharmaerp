package DKSPACE.PhamarERP.crm.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.crm.model.CrmTag;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrmTagCriteria extends BaseCrudCriteria<CrmTag> {
	private StringFilter name;
	private BooleanFilter isActive;
}