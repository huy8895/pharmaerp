package DKSPACE.PhamarERP.user.dto.criteria;


import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.model.User_;
import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
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
	
	@Override
	public List<SingularAttribute<User, String>> searchBy() {
		return List.of(User_.email,
		               User_.username,
		               User_.phoneNumber,
		               User_.firstName,
		               User_.lastName,
		               User_.staffCode);
	}
}
