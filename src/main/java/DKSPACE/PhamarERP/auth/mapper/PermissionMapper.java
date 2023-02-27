package DKSPACE.PhamarERP.auth.mapper;

import DKSPACE.PhamarERP.auth.dto.permission.PermissionDTO;
import DKSPACE.PhamarERP.auth.model.Permission;
import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionMapper implements BaseMapper<PermissionDTO, Permission> {
    private final I18NMessageResolver messageResolver;
    @Override
    public PermissionDTO toDTO(Permission entity) {
        return PermissionDTO.builder()
                            .id(entity.getId())
                            .group(entity.getGroup().name())
                            .groupName(messageResolver.convertMessage(entity.getGroup().getI18nCode()))
                            .key(entity.getKey().name())
                            .keyName(messageResolver.convertMessage(entity.getKey().getI18nCode()))
                            .build();
    }

    @Override
    public Permission toEntity(PermissionDTO dto) {
        // do nothing
        return null;
    }
}
