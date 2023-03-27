package DKSPACE.PhamarERP.document.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.document.model.Document;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCriteria extends BaseCrudCriteria<Document> {
	@Override
	public List<SingularAttribute<Document, String>> searchBy() {
		return List.of();
	}
}