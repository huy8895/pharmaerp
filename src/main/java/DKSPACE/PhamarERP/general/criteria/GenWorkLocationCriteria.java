package DKSPACE.PhamarERP.general.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.general.model.GenWorkLocation;
import DKSPACE.PhamarERP.general.model.GenWorkLocation_;
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
public class GenWorkLocationCriteria extends BaseCrudCriteria<GenWorkLocation> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter describe;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<GenWorkLocation, String>> searchBy() {
		return List.of(GenWorkLocation_.nameVi,
		               GenWorkLocation_.nameEn,
		               GenWorkLocation_.describe);
	}
}
