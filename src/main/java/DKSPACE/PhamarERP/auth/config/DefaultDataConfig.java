package DKSPACE.PhamarERP.auth.config;

import DKSPACE.PhamarERP.auth.enums.PermissionGroupEnum;
import DKSPACE.PhamarERP.auth.enums.RoleEnum;
import DKSPACE.PhamarERP.auth.model.Permission;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.repository.PermissionRepository;
import DKSPACE.PhamarERP.auth.repository.RoleRepository;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DefaultDataConfig {
    public static final String SYSTEM_ADMIN = "SYSTEM_ADMIN";
    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    public static final String ADMIN = "admin";
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    private void initAuthDefaultData(){
        List<Permission> permissions = this.setupPermissions();
        this.setupRole(permissions);
        this.setupUserAndRole();
    }
    private void setupUserAndRole() {
        User admin = buildAdminUser();
        userRepository.findByEmail(ADMIN)
                      .ifPresentOrElse(user -> {
                                           admin.setId(user.getId());
                                           this.userRepository.save(admin);
                                       },
                                       () -> this.userRepository.save(admin));
    }

    private User buildAdminUser() {
        return User.builder()
                   .email(ADMIN)
                   .password(passwordEncoder.encode(ADMIN))
                   .lastName(ADMIN)
                   .type(SYSTEM_ADMIN)
                   .username(ADMIN)
                   .firstName(ADMIN)
                   .roles(roleRepository.findAllByNameEn(RoleEnum.ROLE_ADMIN.name()))
                   .staffCode(ADMIN)
                   .build();
    }
    private void setupRole(List<Permission> permissions) {
        Set<Role> rolesDefault = Arrays.stream(RoleEnum.values())
                                       .map(roleEnum -> this.buildRole(permissions, roleEnum))
                                       .collect(Collectors.toSet());

        if (!roleRepository.findAll().isEmpty()) {
            log.info("Role already import");
            return;
        }
        roleRepository.saveAll(rolesDefault);
        log.info("setupRole = " + rolesDefault);
    }

    private Role buildRole(List<Permission> permissions, RoleEnum roleEnum) {
        Role defaultRole = Role.builder()
                               .isDefault(true)
                               .isActive(true)
                               .nameEn(roleEnum.name())
                               .nameVi(roleEnum.getNameVi())
                               .build();

        if (roleEnum.equals(RoleEnum.ROLE_ADMIN)){
            defaultRole.setPermissions(new HashSet<>(permissions));
        }
        return defaultRole;
    }

    private List<Permission> setupPermissions() {
        Set<Permission> collect = Arrays.stream(PermissionGroupEnum.values())
                                        .map(this::buildPermission)
                                        .flatMap(Collection::stream)
                                        .collect(Collectors.toSet());;

        List<Permission> permissionAll = permissionRepository.findAll();
        if (!permissionAll.isEmpty()) {
            log.info("Permission already import");
            return permissionAll;
        }
        log.info("setupPermissions = " + collect);
        return permissionRepository.saveAll(collect);
    }

    private List<Permission> buildPermission(PermissionGroupEnum groupEnum) {
        return groupEnum.getKeys()
                        .stream()
                        .map(generateI18NCode -> Permission.builder()
                                                           .group(groupEnum.name())
                                                           .key(generateI18NCode.name())
                                                           .isActive(true)
                                                           .build())
                        .toList();
    }
}
