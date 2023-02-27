package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.repository.RoleRepository;
import DKSPACE.PhamarERP.auth.service.RoleService;
import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleServiceImpl extends AbstractBaseCRUDService<Role, RoleRepository> implements RoleService {
    protected RoleServiceImpl(RoleRepository repository) {
        super(repository);
    }

    @Override
    public Role createRole(Role baseCRUDEntity) {
        Role role = Role.builder()
        		.describe(baseCRUDEntity.getDescribe())
        		.isDefault(false)
        		.isActive(true)
        		.permissions(baseCRUDEntity.getPermissions())
        		.nameVi(baseCRUDEntity.getNameVi())
        		.nameEn(baseCRUDEntity.getNameEn())
        		.build();
        return super.save(role);
    }
}
