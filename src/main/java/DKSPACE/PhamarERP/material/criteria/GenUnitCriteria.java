package DKSPACE.PhamarERP.material.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.material.model.GenUnit;
import DKSPACE.PhamarERP.material.model.GenUnit_;
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
public class GenUnitCriteria extends BaseCrudCriteria<GenUnit> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<GenUnit, String>> searchBy() {
		return List.of(GenUnit_.nameVi, GenUnit_.nameEn);
	}
}