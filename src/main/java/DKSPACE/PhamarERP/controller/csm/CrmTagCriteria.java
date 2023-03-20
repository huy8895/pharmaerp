package DKSPACE.PhamarERP.controller.csm;

import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmTag;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrmTagCriteria implements Criteria<CrmTag> {
	private StringFilter name;
	private BooleanFilter isActive;
}