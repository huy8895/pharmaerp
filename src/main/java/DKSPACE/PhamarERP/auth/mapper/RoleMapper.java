package DKSPACE.PhamarERP.auth.mapper;

import DKSPACE.PhamarERP.auth.dto.permission.PermissionDTO;
import DKSPACE.PhamarERP.auth.dto.role.RoleCreateDTO;
import DKSPACE.PhamarERP.auth.dto.role.RoleDTO;
import DKSPACE.PhamarERP.auth.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleMapper {
    private final PermissionMapper permissionMapper;

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

    public Role toEntity(RoleDTO dto) {
        return Role.builder()
                   .describe(dto.getDescribe())
                   .nameVi(dto.getNameVi())
                   .nameEn(dto.getNameEn())
                   .build();
    }

    public Role toEntity(RoleCreateDTO roleReqDto) {
        return Role.builder()
        		.describe(roleReqDto.getDescribe())
        		.permissions(permissionMapper.toEntity(roleReqDto.getPermissionsId()))
        		.nameVi(roleReqDto.getNameVi())
        		.nameEn(roleReqDto.getNameEn())
        		.build();
    }
}
