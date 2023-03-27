package DKSPACE.PhamarERP.factory.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.factory.model.Factory;
import DKSPACE.PhamarERP.factory.model.Factory_;
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
public class FactoryCriteria extends BaseCrudCriteria<Factory> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter factoryCode;
	private StringFilter describe;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<Factory, String>> searchBy() {
		return List.of(Factory_.nameVi,
		               Factory_.nameEn,
		               Factory_.factoryCode,
		               Factory_.describe);
	}
}
