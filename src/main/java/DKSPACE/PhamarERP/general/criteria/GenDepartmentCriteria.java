package DKSPACE.PhamarERP.general.criteria;


import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.general.model.GenDepartment;
import DKSPACE.PhamarERP.general.model.GenDepartment_;
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
public class GenDepartmentCriteria extends BaseCrudCriteria<GenDepartment> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter describe;
	private BooleanFilter isActive;
	
	@Override
	public List<SingularAttribute<GenDepartment, String>> searchBy() {
		return List.of(GenDepartment_.nameVi,
		               GenDepartment_.nameEn,
		               GenDepartment_.describe);
	}
}
