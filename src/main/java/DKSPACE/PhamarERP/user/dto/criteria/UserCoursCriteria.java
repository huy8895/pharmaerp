package DKSPACE.PhamarERP.user.dto.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.user.model.UserCours;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCoursCriteria extends BaseCrudCriteria<UserCours> {
	private LongFilter userId;
	private StringFilter name;
	private StringFilter organization;
	private StringFilter startDate;
	private StringFilter endDate;
	private StringFilter describe;
	private StringFilter link;
}