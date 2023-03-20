package DKSPACE.PhamarERP.master_data.dto.criteria;


import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.master_data.entity.GenJobTitle;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenJobTitleCriteria implements Criteria<GenJobTitle> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private LongFilter salary;
	private StringFilter describe;
	private BooleanFilter isActive;
}