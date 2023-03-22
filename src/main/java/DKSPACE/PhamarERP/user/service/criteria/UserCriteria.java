package DKSPACE.PhamarERP.user.service.criteria;


import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCriteria extends BaseCrudCriteria<User> {
	private StringFilter email;
	private StringFilter username;
	private StringFilter phoneNumber;
	private StringFilter firstName;
	private StringFilter lastName;
	private StringFilter staffCode;
	
	private BooleanFilter isActive;
	private LongFilter roleId;
	private UserTypeFilter type;
	
	public static class UserTypeFilter extends Filter<UserType> {
		public UserTypeFilter() {}
	}
}
