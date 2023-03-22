package DKSPACE.PhamarERP.general.criteria;


import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.general.model.GenDepartment;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

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
}