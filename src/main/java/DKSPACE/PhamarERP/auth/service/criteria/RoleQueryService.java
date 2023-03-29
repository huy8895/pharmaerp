package DKSPACE.PhamarERP.auth.service.criteria;

import DKSPACE.PhamarERP.auth.dto.role.RoleCriteria;
import DKSPACE.PhamarERP.auth.model.Permission_;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.Role_;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import jakarta.persistence.criteria.JoinType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleQueryService extends FilterService<Role, RoleCriteria> {
	
	public Specification<Role> createSpecification(RoleCriteria criteria) {
		return SpecificationBuilder
				.<Role>builder()
				.and(criteria.getDescribe(), Role_.describe, super::buildStringSpecification)
				.and(criteria.getIsActive(), Role_.isActive, super::buildSpecification)
				.and(criteria.getIsDefault(), Role_.isDefault, super::buildSpecification)
				.and(criteria.getNameEn(), Role_.nameEn, super::buildStringSpecification)
				.and(criteria.getNameVi(), Role_.nameVi, super::buildStringSpecification)
				.and(criteria.getPermissionId(), root -> root.join(Role_.permissions, JoinType.LEFT).get(Permission_.id),
				     super::buildRangeSpecification)
				.build();
	}
}
    
 