package DKSPACE.PhamarERP.material.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.material.model.Material;
import DKSPACE.PhamarERP.material.model.Material_;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialCriteria extends BaseCrudCriteria<Material> {
	
	private LongFilter genUnitId;
	private LongFilter materialGroupId;
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter nameScience;
	private StringFilter nameOther;
	private LongFilter inventoryMin;
	private LongFilter inventoryMax;
	private StringFilter describe;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<Material, String>> searchBy() {
		return List.of(Material_.nameVi, Material_.nameEn, Material_.nameScience, Material_.nameOther, Material_.describe);
	}
}