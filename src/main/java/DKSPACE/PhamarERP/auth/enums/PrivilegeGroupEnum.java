package DKSPACE.PhamarERP.auth.enums;

import static DKSPACE.PhamarERP.auth.enums.PrivilegeKeyEnum.*;

public enum PrivilegeGroupEnum {
    Role(CREATE,UPDATE),

    ;


    PrivilegeGroupEnum(PrivilegeKeyEnum... keys) {
    }
}
