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

import java.util.*;
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
    private void initAuthDefaultData(){
        log.info("initAuthDefaultData");
        List<Permission> permissions = this.setupPermissions();
        this.setupRole(permissions);
        this.setupUserAndRole();
    }
    private void setupUserAndRole() {
        log.info("setupUserAdmin");
        User admin = buildAdminUser();
        userRepository.findByEmail(admin.getEmail())
                      .ifPresentOrElse(user -> {
                                           admin.setId(user.getId());
                                           this.userRepository.save(admin);
                                       },
                                       () -> this.userRepository.save(admin));
    }

    private User buildAdminUser() {

        return User.builder()
                   .email(adminConfig.email())
                   .password(passwordEncoder.encode(adminConfig.password()))
                   .lastName(adminConfig.lastname())
                   .type(UserType.SUPER_ADMIN)
                   .username(adminConfig.username())
                   .firstName(adminConfig.firstname())
                   .staffCode(adminConfig.staffCode())
                   .build();
    }
    private void setupRole(List<Permission> permissions) {
        log.info("setupRole");
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
        log.info("setupPermissions");
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
                        .map(keyEnum -> Permission.builder()
                                                           .group(groupEnum)
                                                           .key(keyEnum)
                                                           .isActive(true)
                                                           .build())
                        .toList();
    }
}
