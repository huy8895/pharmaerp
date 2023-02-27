package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.dto.permission.PermissionsDTO;
import DKSPACE.PhamarERP.auth.enums.PermissionGroupEnum;
import DKSPACE.PhamarERP.auth.model.Permission;
import DKSPACE.PhamarERP.auth.repository.PermissionRepository;
import DKSPACE.PhamarERP.auth.service.PermissionService;
import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import DKSPACE.PhamarERP.i18n.enums.GenerateI18NCode;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository repository;
    private final I18NMessageResolver messageResolver;

    @PostConstruct
    private void setupPermissions() {
        List<Permission> collect = Arrays.stream(PermissionGroupEnum.values())
                                         .map(this::build)
                                         .flatMap(Collection::stream)
                                         .toList();

        if (!repository.findAll().isEmpty()) {
            log.info("Permission already import");
            return;
        }
        repository.saveAll(collect);
        System.out.println("collect = " + collect);
        ;
    }

    private List<Permission> build(PermissionGroupEnum groupEnum) {
        return groupEnum.getKeys()
                        .stream()
                        .map(generateI18NCode -> Permission.builder()
                                                           .group(groupEnum.name())
                                                           .key(generateI18NCode.name())
                                                           .isActive(true)
                                                           .build())
                        .collect(Collectors.toList());
    }

    @Override
    public Object getAll() {
        return repository.findAll()
                         .stream()
                         .map(permission -> mapToDTO(permission))
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
        GenerateI18NCode i18NCode = groupEnum.getKey(key);
        if (i18NCode == null) return null;
        System.out.println( i18NCode.getI18NCodeForKey());
        return messageResolver.convertMessage(i18NCode.getI18NCodeForKey());
//        return i18NCode.getI18NCodeForKey();
    }

    private String getGroupName(PermissionGroupEnum groupEnum) {
        if (groupEnum == null) return "";
        return messageResolver.convertMessage(groupEnum.getGroupNameI18NCode());
    }
}
