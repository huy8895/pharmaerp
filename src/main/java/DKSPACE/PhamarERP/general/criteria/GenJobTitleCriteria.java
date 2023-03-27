package DKSPACE.PhamarERP.general.criteria;


import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.general.model.GenJobTitle;
import DKSPACE.PhamarERP.general.model.GenJobTitle_;
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
public class GenJobTitleCriteria extends BaseCrudCriteria<GenJobTitle> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private LongFilter salary;
	private StringFilter describe;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<GenJobTitle, String>> searchBy() {
		return List.of(GenJobTitle_.nameVi,
		               GenJobTitle_.nameEn,
		               GenJobTitle_.describe);
	}
}
