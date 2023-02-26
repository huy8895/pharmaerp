package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.enums.PermissionGroupEnum;
import DKSPACE.PhamarERP.auth.model.Permission;
import DKSPACE.PhamarERP.auth.repository.PermissionRepository;
import DKSPACE.PhamarERP.auth.service.PermissionService;
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

    @PostConstruct
    private void setupPermissions() {
        List<Permission> collect = Arrays.stream(PermissionGroupEnum.values())
                                         .map(this::build)
                                         .flatMap(Collection::stream)
                                         .toList();

        repository.saveAll(collect);
        System.out.println("collect = " + collect);
        ;
    }

    private List<Permission> build(PermissionGroupEnum groupEnum){
        return Arrays.stream(groupEnum.getValues())
              .map(generateI18NCode -> Permission.builder()
                                                    .group(groupEnum.name())
                                                    .key(generateI18NCode.name())
                                                    .isActive(true)
                                                    .build())
                .collect(Collectors.toList());
    }

    @Override
    public Object getAll() {
        return repository.findAll();
    }
}
