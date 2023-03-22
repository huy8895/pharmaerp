package DKSPACE.PhamarERP.user.dto.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.user.model.ContractType;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractTypeCriteria extends BaseCrudCriteria<ContractType> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private BooleanFilter isDetermineDeadline;
	private BooleanFilter isActive;
	private StringFilter describe;
}
