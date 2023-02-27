package DKSPACE.PhamarERP.auth.mapper;

import DKSPACE.PhamarERP.auth.dto.permission.PermissionDTO;
import DKSPACE.PhamarERP.auth.dto.role.RoleDTO;
import DKSPACE.PhamarERP.auth.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleMapper implements BaseMapper<RoleDTO, Role> {
    private final PermissionMapper permissionMapper;

    @Override
    public RoleDTO toDTO(Role entity) {
        List<PermissionDTO> permissionDTOS = entity.getPermissions()
                                                   .stream()
                                                   .map(permissionMapper::toDTO)
                                                   .toList();
        return RoleDTO.builder()
                      .id(entity.getId())
                      .describe(entity.getDescribe())
                      .nameVi(entity.getNameVi())
                      .nameEn(entity.getNameEn())
                      .permissions(permissionDTOS)
                      .build();
    }

    @Override
    public Role toEntity(RoleDTO dto) {
        return Role.builder()
                   .describe(dto.getDescribe())
                   .nameVi(dto.getNameVi())
                   .nameEn(dto.getNameEn())
                   .build();
    }
}
