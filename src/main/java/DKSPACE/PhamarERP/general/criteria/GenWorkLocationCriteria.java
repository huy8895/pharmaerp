package DKSPACE.PhamarERP.general.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.general.model.GenWorkLocation;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenWorkLocationCriteria extends BaseCrudCriteria<GenWorkLocation> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter describe;
	private BooleanFilter isActive;
}