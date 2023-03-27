package DKSPACE.PhamarERP.user.dto.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.user.model.ContractType;
import DKSPACE.PhamarERP.user.model.ContractType_;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.*;

import java.util.List;

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
	
	@Override
	public List<SingularAttribute<ContractType, String>> searchBy() {
		return List.of(ContractType_.nameVi,
		               ContractType_.nameEn,
		               ContractType_.describe);
	}
}

