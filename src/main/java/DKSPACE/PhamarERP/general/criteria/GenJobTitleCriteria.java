package DKSPACE.PhamarERP.general.criteria;


import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.general.model.GenJobTitle;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

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
}