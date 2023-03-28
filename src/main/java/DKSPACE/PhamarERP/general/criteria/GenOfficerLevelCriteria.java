package DKSPACE.PhamarERP.general.criteria;


import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.general.model.GenOfficerLevel;
import DKSPACE.PhamarERP.general.model.GenOfficerLevel_;
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
public class GenOfficerLevelCriteria extends BaseCrudCriteria<GenOfficerLevel> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter describe;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<GenOfficerLevel, String>> searchBy() {
		return List.of(GenOfficerLevel_.nameVi,
		               GenOfficerLevel_.nameEn,
		               GenOfficerLevel_.describe);
	}
}
