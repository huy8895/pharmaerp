package DKSPACE.PhamarERP.auth.config;

import DKSPACE.PhamarERP.auth.config.properties.AdminConfig;
import DKSPACE.PhamarERP.auth.enums.RoleEnum;
import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionGroupEnum;
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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DefaultDataConfig {
    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminConfig adminConfig;

    @PostConstruct
    private void initAuthDefaultData() {
        log.info("initAuthDefaultData");
        this.setupPermissions();
        this.setupDefaultRole();
        this.setupUserAndRole();
    }

    private void setupUserAndRole() {
        log.info("setupUserAdmin");
        User admin = buildSuperAdminUser();
        userRepository.findByEmail(admin.getEmail())
                      .ifPresentOrElse(user -> {
                                           admin.setId(user.getId());
                                           this.userRepository.save(admin);
                                       },
                                       () -> this.userRepository.save(admin));
    }

    private User buildSuperAdminUser() {

        return User.builder()
                   .email(adminConfig.email())
                   .password(passwordEncoder.encode(adminConfig.password()))
                   .lastName(adminConfig.lastname())
                   .type(UserType.SUPER_ADMIN)
                   .isActive(true)
                   .username(adminConfig.username())
                   .firstName(adminConfig.firstname())
                   .staffCode(adminConfig.staffCode())
                   .build();
    }

    private void setupDefaultRole() {
        log.info("setupDefaultRole");
        Set<Role> rolesDefault = Arrays.stream(RoleEnum.values())
                                       .map(this::buildRole)
                                       .collect(Collectors.toSet());

        if (!roleRepository.findAll()
                           .isEmpty()) {
            log.info("Role already import");
            return;
        }

        roleRepository.saveAll(rolesDefault);
        log.info("setupDefaultRole = " + rolesDefault);
    }

    private Role buildRole(RoleEnum roleEnum) {
        return Role.builder()
                   .isDefault(true)
                   .isActive(true)
                   .nameEn(roleEnum.getNameEn())
                   .nameVi(roleEnum.getNameVi())
                   .build();
    }

    private void setupPermissions() {
        log.info("setupPermissions");
        Set<Permission> collect = Arrays.stream(PermissionGroupEnum.values())
                                        .map(this::buildPermission)
                                        .flatMap(Collection::stream)
                                        .collect(Collectors.toSet());

        List<Permission> permissionAll = permissionRepository.findAll();
        List<Permission> newPermission = collect.stream()
                                                .filter(permission -> permissionAll.stream()
                                                                                   .noneMatch(p -> p.getKey()
                                                                                                    .equals(permission.getKey())))
                                                .toList();

        if (newPermission.isEmpty()) {
            log.info("Permission already import");
            return;
        }
        log.info("setupPermissions = {}", newPermission);
        permissionRepository.saveAll(newPermission);
        return;
    }

    private List<Permission> buildPermission(PermissionGroupEnum groupEnum) {
        return groupEnum.getKeys()
                        .stream()
                        .map(keyEnum -> Permission.builder()
                                                  .group(groupEnum)
                                                  .key(keyEnum)
                                                  .isActive(true)
                                                  .build())
                        .toList();
    }
}
