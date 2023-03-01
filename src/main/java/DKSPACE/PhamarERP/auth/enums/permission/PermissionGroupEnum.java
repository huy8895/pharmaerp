package DKSPACE.PhamarERP.auth.enums.permission;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum.*;


public enum PermissionGroupEnum implements HasI18NCode{
    ROLE(
            Role.class,
            "permission.group.role",
            CREATE_ROLE,
            UPDATE_ROLE,
            LIST_ROLE,
            DELETE_ROLE,
            DETAIL_ROLE
    ),

    USER(
            User.class,
            "permission.group.user",
            CREATE_USER,
            UPDATE_USER,
            GET_LIST_USER,
            TOGGLE_ACTIVE_USER,
            ADD_ROLES_USER,
            EXPORT_USER,
            IMPORT_USER,
            CHANGE_PASSWORD_USER
            ),

    ;

    static {
       groupEnumMap = Arrays.stream(values()).collect(Collectors.toMap(Enum::name, p -> p));
    }

    private static final Map<String, PermissionGroupEnum> groupEnumMap;
    private final Class<?> entityClass;
    private final String i18nCode;
    private final List<PermissionKeyEnum> keys;

    PermissionGroupEnum(Class<?> entityClass, String i18nCode, PermissionKeyEnum... permissionKeyEnums) {
        this.entityClass = entityClass;
        this.i18nCode = i18nCode;
        this.keys = List.of(permissionKeyEnums);
    }

    public static PermissionGroupEnum from(String groupName) {
        return groupEnumMap.get(groupName);
    }

    public Map<String, PermissionGroupEnum> getGroupEnumMap() {
        return groupEnumMap;
    }

    public PermissionKeyEnum getKey(String key) {
        return this.keys.stream()
                        .filter(i18NCode -> i18NCode.name().equals(key))
                        .findFirst()
                        .orElse(null);
    }

    public List<PermissionKeyEnum> getKeys() {
        return this.keys;
    }

    @Override
    public String getI18nCode() {
        return i18nCode;
    }
}
