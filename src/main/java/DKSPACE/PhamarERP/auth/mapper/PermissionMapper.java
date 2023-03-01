package DKSPACE.PhamarERP.auth.mapper;

import DKSPACE.PhamarERP.auth.dto.permission.PermissionDTO;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionGroupEnum;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.auth.model.Permission;
import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionMapper  {
    private final I18NMessageResolver messageResolver;
    public PermissionDTO toDTO(Permission entity) {
        return PermissionDTO.builder()
                            .id(entity.getId())
                            .group(Optional.ofNullable(entity.getGroup())
                                           .map(PermissionGroupEnum::name)
                                           .orElse(null))
                            .groupName(messageResolver.convertMessage(entity.getGroup()))
                            .key(Optional.ofNullable(entity.getKey())
                                         .map(PermissionKeyEnum::name)
                                         .orElse(null))
                            .keyName(messageResolver.convertMessage(entity.getKey()))
                            .build();
    }

    public List<PermissionDTO> toDTOList(Set<Permission> entity) {
        return entity.stream()
                     .map(this::toDTO)
                     .toList();
    }

    public Set<Permission> toEntity(List<Long> permissionsId) {
        if (CollectionUtils.isEmpty(permissionsId)) {
            return Set.of();
        }
        return permissionsId.stream()
                     .map(id -> {
                         Permission permission = new Permission();
                         permission.setId(id);
                         return permission;
                     })
                     .collect(Collectors.toSet());
    }
}
