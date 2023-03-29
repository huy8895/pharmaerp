package DKSPACE.PhamarERP.auth.dto.role;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.Role_;
import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import io.github.jhipster.service.filter.BooleanFilter;
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
public class RoleCriteria extends BaseCrudCriteria<Role> {
	private BooleanFilter isDefault;
	private BooleanFilter isActive;
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter describe;
	private LongFilter permissionId;
	
	@Override
	public List<SingularAttribute<Role, String>> searchBy() {
		return List.of(Role_.nameVi, Role_.nameEn, Role_.describe);
	}
}

