package DKSPACE.PhamarERP.auth.enums;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.i18n.enums.GenerateI18NCode;
import DKSPACE.PhamarERP.i18n.enums.PermissionI18N;

import java.util.Arrays;
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
    private final GenerateI18NCode[] values;

    PermissionGroupEnum(Class<?> entityClass, GenerateI18NCode[] i18NCodes) {
        this.entityClass = entityClass;
        this.values = i18NCodes;
    }

    public Map<String, PermissionGroupEnum> getGroupEnumMap() {
        return groupEnumMap;
    }

    public GenerateI18NCode[] getValues() {
        return values;
    }

    public String getGroupNameI18NCode() {
        return "permission".concat(this.name().toLowerCase());
    }

    public static void main(String[] args) {

    }
}
