package DKSPACE.PhamarERP.user.dto.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.user.model.UserCertificate;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCertificateCriteria extends BaseCrudCriteria<UserCertificate> {
	private LongFilter userId;
	private StringFilter name;
	private StringFilter organization;
	private BooleanFilter hasNoExpirationDate;
	private StringFilter startDate;
	private StringFilter endDate;
	private StringFilter link;
}