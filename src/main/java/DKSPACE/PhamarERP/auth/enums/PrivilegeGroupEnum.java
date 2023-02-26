package DKSPACE.PhamarERP.auth.enums;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.i18n.enums.GenerateI18NCode;
import DKSPACE.PhamarERP.i18n.enums.PrivilegeI18N;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


public enum PrivilegeGroupEnum {
    ROLE(
            Role.class,
            PrivilegeI18N.ROLE.class,
            PrivilegeI18N.ROLE.values()
    ),

    USER(
            User.class,
            PrivilegeI18N.USER.class,
            PrivilegeI18N.USER.values()
            ),


    //todo: i18n

    ;

    static {
       groupEnumMap = Arrays.stream(values()).collect(Collectors.toMap(Enum::name, p -> p));
    }

    private static final Map<String, PrivilegeGroupEnum> groupEnumMap;
    private final Class<?> entityClass;
    private final Class<? extends GenerateI18NCode> groupClass;
    private final GenerateI18NCode[] values;

    PrivilegeGroupEnum(Class<?> entityClass, Class<? extends GenerateI18NCode> groupClass, GenerateI18NCode[] i18NCodes) {
        this.entityClass = entityClass;
        this.groupClass = groupClass;
        this.values = i18NCodes;
    }

    public Map<String, PrivilegeGroupEnum> getGroupEnumMap() {
        return groupEnumMap;
    }

    public GenerateI18NCode[] getValues() {
        return values;
    }

    public String getGroupNameI18NCode() {
        return GenerateI18NCode.PRIVILEGE_GROUP_PREFIX.concat(this.groupClass.getSimpleName()
                                                                              .toLowerCase());
    }
}
