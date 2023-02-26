package DKSPACE.PhamarERP.auth.enums;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.i18n.enums.PrivilegeGroupNameI18N;
import DKSPACE.PhamarERP.i18n.enums.PrivilegeKeyI18N;

import static DKSPACE.PhamarERP.auth.enums.PrivilegeKeyEnum.*;


public enum PrivilegeGroupEnum {
    ROLE(
            Role.class,
            PrivilegeGroupNameI18N.ROLE,
            READ.i18n(PrivilegeKeyI18N.ROLE_CREATE),
            UPDATE.i18n(PrivilegeKeyI18N.ROLE_CREATE),
            DELETE.i18n(PrivilegeKeyI18N.ROLE_CREATE)
    ),

    USER(
            User.class,
            PrivilegeGroupNameI18N.USER,


            ),


    //todo: i18n

    ;


    private final PrivilegeGroupNameI18N groupName;
    private final PrivilegeKeyEnum[] privilegeKeyEnums;

    PrivilegeGroupEnum(Class<?> eClass,
                       PrivilegeGroupNameI18N groupName,
                       PrivilegeKeyEnum... privilegeKeyEnums) {
        this.groupName = groupName;
        this.privilegeKeyEnums = privilegeKeyEnums;
    }

}
