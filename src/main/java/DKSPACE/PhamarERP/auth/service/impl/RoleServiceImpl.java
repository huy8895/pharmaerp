package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.dto.role.RoleCreateDTO;
import DKSPACE.PhamarERP.auth.dto.role.RoleCriteria;
import DKSPACE.PhamarERP.auth.dto.role.RoleDTO;
import DKSPACE.PhamarERP.auth.dto.role.RoleUpdateDTO;
import DKSPACE.PhamarERP.auth.mapper.RoleMapper;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.repository.RoleRepository;
import DKSPACE.PhamarERP.auth.service.RoleService;
import DKSPACE.PhamarERP.auth.service.criteria.RoleQueryService;
import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
public class RoleServiceImpl extends AbstractBaseCRUDService<Role, RoleRepository> implements RoleService {
    private final RoleMapper roleMapper;
    private final FilterService<Role, RoleCriteria> queryService;

    protected RoleServiceImpl(RoleRepository repository,
                              RoleMapper roleMapper,
                              RoleQueryService queryService) {
        super(repository);
        this.roleMapper = roleMapper;
        this.queryService = queryService;
    }

    @Override
    public RoleDTO createRole(RoleCreateDTO roleReqDto) {
        Role newRole = roleMapper.toEntity(roleReqDto);
        newRole.setIsActive(true);
        newRole.setIsDefault(false);
        return roleMapper.toDTO(super.save(newRole));
    }

    @Override
    public Page<RoleDTO> listRoles(Pageable unpaged, RoleCriteria criteria) {
        return queryService.findByCriteria(criteria, unpaged, repository::findAll)
                           .map(roleMapper::toDTO);
    }

    @Override
    public RoleDTO detailRole(Long id) {
        Role one = super.findOne(id);
        return roleMapper.toDTO(one);
    }

    @Override
    public void deleteRole(Long id) {
        boolean isAssigned = repository.existsByRoleIdJoinUsersRole(id);
        if (isAssigned){
            throw new ClientException(ApiResponseInfo.ROLE_ALREADY_ASSIGN);
        }

        super.softDelete(id);
    }

    @Override
    public RoleDTO updateRole(RoleUpdateDTO role) {
        Role entity = roleMapper.toEntity(role);
        final var permissionsNew = entity.getPermissions();
        entity.setPermissions(Collections.emptySet());
        Role roleUpdatePermission = super.partialUpdate(entity);
        roleUpdatePermission.setPermissions(permissionsNew);
        return roleMapper.toDTO(super.save(roleUpdatePermission));
    }
}
