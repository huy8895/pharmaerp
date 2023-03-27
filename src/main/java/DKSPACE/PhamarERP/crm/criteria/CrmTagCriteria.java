package DKSPACE.PhamarERP.crm.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.crm.model.CrmTag;
import DKSPACE.PhamarERP.crm.model.CrmTag_;
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
public class CrmTagCriteria extends BaseCrudCriteria<CrmTag> {
	private StringFilter name;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<CrmTag, String>> searchBy() {
		return List.of(CrmTag_.name);
	}
}
