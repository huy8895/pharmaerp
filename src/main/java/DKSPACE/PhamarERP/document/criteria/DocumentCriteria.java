package DKSPACE.PhamarERP.document.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.document.model.Document;
import DKSPACE.PhamarERP.document.model.Document_;
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
public class DocumentCriteria extends BaseCrudCriteria<Document> {
	private LongFilter documentGroupId;
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter describe;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<Document, String>> searchBy() {
		return List.of(Document_.nameVi, Document_.nameEn, Document_.describe);
	}
}