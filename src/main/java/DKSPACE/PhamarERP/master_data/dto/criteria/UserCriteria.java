package DKSPACE.PhamarERP.master_data.dto.criteria;


import DKSPACE.PhamarERP.auth.enums.UserType;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCriteria implements Serializable {
	private StringFilter search;
	
	private BooleanFilter isActive;
	private LongFilter roleId;
	private UserTypeFilter type;
	
	public static class UserTypeFilter extends Filter<UserType> {
		public UserTypeFilter() {}
	}
}
