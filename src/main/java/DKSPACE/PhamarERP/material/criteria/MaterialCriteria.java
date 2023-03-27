package DKSPACE.PhamarERP.material.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.material.model.Material;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialCriteria extends BaseCrudCriteria<Material> {
	@Override
	public List<SingularAttribute<Material, String>> searchBy() {
		return List.of();
	}
}