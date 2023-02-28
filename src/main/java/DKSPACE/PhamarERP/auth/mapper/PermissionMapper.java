package DKSPACE.PhamarERP.auth.mapper;

import DKSPACE.PhamarERP.auth.dto.permission.PermissionDTO;
import DKSPACE.PhamarERP.auth.model.Permission;
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
        return PermissionDTO.builder()
                            .id(entity.getId())
                            .group(entity.getGroup().name())
                            .groupName(messageResolver.convertMessage(entity.getGroup().getI18nCode()))
                            .key(entity.getKey().name())
                            .keyName(messageResolver.convertMessage(entity.getKey().getI18nCode()))
                            .build();
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
