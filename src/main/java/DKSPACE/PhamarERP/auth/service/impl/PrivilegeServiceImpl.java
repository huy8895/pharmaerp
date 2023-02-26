package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.enums.PrivilegeGroupEnum;
import DKSPACE.PhamarERP.auth.model.Privilege;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.repository.PrivilegeRepository;
import DKSPACE.PhamarERP.auth.service.PrivilegeService;
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
public class PrivilegeServiceImpl implements PrivilegeService {
    private final PrivilegeRepository repository;

    @PostConstruct
    private void setupPrivileges() {
        List<Privilege> collect = Arrays.stream(PrivilegeGroupEnum.values())
                                        .map(this::build)
                                        .flatMap(Collection::stream)
                                        .toList();

        System.out.println("collect = " + collect);
        ;
    }

    private List<Privilege> build(PrivilegeGroupEnum groupEnum){
        return Arrays.stream(groupEnum.getValues())
              .map(generateI18NCode -> Privilege.builder()
                                                    .group(groupEnum.name())
                                                    .name(generateI18NCode.getPrivilegeKeyName())
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
