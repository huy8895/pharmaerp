package DKSPACE.PhamarERP.auth.enums;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.i18n.enums.GenerateI18NCode;
import DKSPACE.PhamarERP.i18n.enums.PermissionI18N;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public enum PermissionGroupEnum {
    ROLE(
            Role.class,
            PermissionI18N.ROLE.values()
    ),

    USER(
            User.class,
            PermissionI18N.USER.values()
            ),


    //todo: i18n

    ;

    static {
       groupEnumMap = Arrays.stream(values()).collect(Collectors.toMap(Enum::name, p -> p));
    }

    private static final Map<String, PermissionGroupEnum> groupEnumMap;
    private final Class<?> entityClass;
    private final List<GenerateI18NCode> keys;

    PermissionGroupEnum(Class<?> entityClass, GenerateI18NCode[] i18NCodes) {
        this.entityClass = entityClass;
        this.keys = List.of(i18NCodes);
    }

    public static PermissionGroupEnum from(String groupName) {
        return groupEnumMap.get(groupName);
    }

    public Map<String, PermissionGroupEnum> getGroupEnumMap() {
        return groupEnumMap;
    }

    public GenerateI18NCode getKey(String key) {
        return this.keys.stream()
                        .filter(i18NCode -> i18NCode.name().equals(key))
                        .findFirst()
                        .orElse(null);
    }

    public String getGroupNameI18NCode() {
        return "permission.group.".concat(this.name().toLowerCase());
    }


    public List<GenerateI18NCode> getKeys() {
        return this.keys;
    }
}
