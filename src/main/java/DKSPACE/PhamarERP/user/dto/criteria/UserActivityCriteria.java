package DKSPACE.PhamarERP.user.dto.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.user.model.UserActivity;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserActivityCriteria extends BaseCrudCriteria<UserActivity> {
	private LongFilter userId;
	private StringFilter organization;
	private StringFilter participatingPosition;
	private BooleanFilter isCurrentActive;
	private StringFilter startDate;
	private StringFilter endDate;
	private StringFilter describe;
	private StringFilter link;
}