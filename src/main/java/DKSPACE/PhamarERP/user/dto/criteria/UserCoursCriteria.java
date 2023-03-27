package DKSPACE.PhamarERP.user.dto.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.user.model.UserCours;
import DKSPACE.PhamarERP.user.model.UserCours_;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCoursCriteria extends BaseCrudCriteria<UserCours> {
	private LongFilter userId;
	private StringFilter name;
	private StringFilter organization;
	private LocalDateFilter startDate;
	private LocalDateFilter endDate;
	private StringFilter describe;
	private StringFilter link;
	
	@Override
	public List<SingularAttribute<UserCours, String>> searchBy() {
		return List.of(UserCours_.name,
		               UserCours_.organization,
		               UserCours_.link);
	}
}