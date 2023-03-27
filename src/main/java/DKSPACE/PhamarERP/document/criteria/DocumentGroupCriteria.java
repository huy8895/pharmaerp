package DKSPACE.PhamarERP.document.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.document.model.DocumentGroup;
import DKSPACE.PhamarERP.document.model.DocumentGroup_;
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
public class DocumentGroupCriteria extends BaseCrudCriteria<DocumentGroup> {
	private LongFilter parentId;
	private StringFilter nameVi;
	private StringFilter nameEn;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<DocumentGroup, String>> searchBy() {
		return List.of(DocumentGroup_.nameVi, DocumentGroup_.nameEn);
	}
}