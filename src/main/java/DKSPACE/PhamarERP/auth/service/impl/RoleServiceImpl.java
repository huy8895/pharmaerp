package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.dto.role.RoleDTO;
import DKSPACE.PhamarERP.auth.mapper.PermissionMapper;
import DKSPACE.PhamarERP.auth.mapper.RoleMapper;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.repository.RoleRepository;
import DKSPACE.PhamarERP.auth.service.RoleService;
import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleServiceImpl extends AbstractBaseCRUDService<Role, RoleRepository> implements RoleService {
    private final RoleMapper roleMapper;
    protected RoleServiceImpl(RoleRepository repository,
                              RoleMapper roleMapper) {
        super(repository);
        this.roleMapper = roleMapper;
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
        return repository.save(role);
    }

    @Override
    public Page<RoleDTO> listRoles(Pageable unpaged) {
        return repository.findAll(unpaged)
                         .map(roleMapper::toDTO);
    }
}
