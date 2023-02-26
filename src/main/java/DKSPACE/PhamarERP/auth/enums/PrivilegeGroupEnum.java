package DKSPACE.PhamarERP.auth.enums;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.i18n.enums.GenerateI18NCode;
import DKSPACE.PhamarERP.i18n.enums.PrivilegeI18N;


public enum PrivilegeGroupEnum {
    ROLE(
            Role.class,
            PrivilegeI18N.ROLE.class,
            PrivilegeI18N.ROLE.values()
    ),

//    USER(
//            User.class,
//
//
//            ),


    //todo: i18n

    ;



    PrivilegeGroupEnum(Class<?> eClass, Class<? extends GenerateI18NCode> roleClass, GenerateI18NCode[] values) {

    }
}
