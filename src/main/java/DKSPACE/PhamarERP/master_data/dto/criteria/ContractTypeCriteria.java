package DKSPACE.PhamarERP.master_data.dto.criteria;

import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.master_data.entity.ContractType;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractTypeCriteria implements Criteria<ContractType> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private BooleanFilter isDetermineDeadline;
	private BooleanFilter isActive;
	private StringFilter describe;
}
