package DKSPACE.PhamarERP.document.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.document.model.DocumentGroup;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentGroupCriteria extends BaseCrudCriteria<DocumentGroup> {
	@Override
	public List<SingularAttribute<DocumentGroup, String>> searchBy() {
		return List.of();
	}
}