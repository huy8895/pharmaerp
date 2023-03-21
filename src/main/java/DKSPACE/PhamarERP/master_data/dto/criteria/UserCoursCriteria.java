package DKSPACE.PhamarERP.master_data.dto.criteria;

import DKSPACE.PhamarERP.helper.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.master_data.entity.UserCours;
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