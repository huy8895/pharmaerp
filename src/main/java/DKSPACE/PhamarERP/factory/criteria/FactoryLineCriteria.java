package DKSPACE.PhamarERP.factory.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.factory.model.FactoryLine;
import DKSPACE.PhamarERP.factory.model.FactoryLine_;
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
public class FactoryLineCriteria extends BaseCrudCriteria<FactoryLine> {
	private LongFilter factoryId;
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter factoryLineCode;
	private StringFilter describe;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<FactoryLine, String>> searchBy() {
		return List.of(
				FactoryLine_.nameVi,
				FactoryLine_.nameEn,
				FactoryLine_.factoryLineCode,
				FactoryLine_.describe
		);
	}
}


