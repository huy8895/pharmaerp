package DKSPACE.PhamarERP.master_data.dto.criteria;


import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.master_data.entity.GenDepartment;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenDepartmentCriteria implements Criteria<GenDepartment> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter describe;
	private BooleanFilter isActive;
}