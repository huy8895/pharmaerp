package DKSPACE.PhamarERP.general.criteria;


import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.general.model.GenOfficerLevel;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenOfficerLevelCriteria extends BaseCrudCriteria<GenOfficerLevel> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter describe;
	private BooleanFilter isActive;
}