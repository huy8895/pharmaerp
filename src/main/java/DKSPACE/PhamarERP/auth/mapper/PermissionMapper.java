package DKSPACE.PhamarERP.auth.mapper;

import DKSPACE.PhamarERP.auth.dto.permission.PermissionDTO;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionGroupEnum;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.auth.model.Permission;
import DKSPACE.PhamarERP.basecrud.BaseCRUDAction;
import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionMapper  {
    private final I18NMessageResolver messageResolver;
    public PermissionDTO toDTO(Permission entity) {
        final var group = PermissionGroupEnum.from(entity.getGroup());
        if (group != null && group.isBaseCRUD()){
            final var baseCRUDAction = BaseCRUDAction.resolveKey(entity.getKey(), group);
            final var groupName = messageResolver.convertMessage(group);
            final var keyName = BaseCRUDAction.getKeyNameI18N(group, baseCRUDAction, messageResolver::convertMessage);
            return PermissionDTO.builder()
                                .id(entity.getId())
                                .group(group.name())
                                .groupName(groupName)
                                .key(entity.getKey())
                                .keyName(keyName)
                                .build();
        }
    
        final var key = PermissionKeyEnum.from(entity.getKey());
        return PermissionDTO.builder()
                            .id(entity.getId())
                            .group(entity.getGroup())
                            .groupName(messageResolver.convertMessage(group))
                            .key(key == null ? null : key.name())
                            .keyName(messageResolver.convertMessage(key))
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
