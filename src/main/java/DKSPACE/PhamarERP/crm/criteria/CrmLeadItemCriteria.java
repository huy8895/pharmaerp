package DKSPACE.PhamarERP.crm.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.crm.model.CrmLeadItem;
import DKSPACE.PhamarERP.crm.model.CrmLeadItem_;
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
public class CrmLeadItemCriteria extends BaseCrudCriteria<CrmLeadItem> {
	private LongFilter crmLeadId;
	private StringFilter name;
	private StringFilter color;
	private StringFilter describe;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<CrmLeadItem, String>> searchBy() {
		return List.of(CrmLeadItem_.name, CrmLeadItem_.color, CrmLeadItem_.describe);
	}
}
