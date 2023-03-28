package DKSPACE.PhamarERP.material.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.material.model.MaterialGroup;
import DKSPACE.PhamarERP.material.model.MaterialGroup_;
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
public class MaterialGroupCriteria extends BaseCrudCriteria<MaterialGroup> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter type;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<MaterialGroup, String>> searchBy() {
		return List.of(MaterialGroup_.nameVi, MaterialGroup_.nameEn);
	}
}
