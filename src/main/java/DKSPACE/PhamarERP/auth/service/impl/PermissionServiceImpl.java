package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.dto.permission.PermissionsDTO;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionGroupEnum;
import DKSPACE.PhamarERP.auth.model.Permission;
import DKSPACE.PhamarERP.auth.repository.PermissionRepository;
import DKSPACE.PhamarERP.auth.service.PermissionService;
import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository repository;
    private final I18NMessageResolver messageResolver;



    @Override
    public Object getAll() {
        return repository.findAll()
                         .stream()
                         .map(this::mapToDTO)
                         .toList();
    }

    private PermissionsDTO mapToDTO(Permission permission){
        PermissionGroupEnum groupEnum = PermissionGroupEnum.from(permission.getGroup());
        return PermissionsDTO.builder()
                             .id(permission.getId())
                             .group(permission.getGroup())
                             .groupName(getGroupName(groupEnum))
                             .key(permission.getKey())
                             .keyName(getKeyName(groupEnum, permission.getKey()))
                             .build();
    }

    private String getKeyName(PermissionGroupEnum groupEnum, String key) {
        final var i18NCode = groupEnum.getKey(key);
        if (i18NCode == null) return null;
        System.out.println( i18NCode.getI18nCode());
        return messageResolver.convertMessage(i18NCode.getI18nCode());
    }

    private String getGroupName(PermissionGroupEnum groupEnum) {
        if (groupEnum == null) return "";
        return messageResolver.convertMessage(groupEnum.getI18nCode());
    }
}
