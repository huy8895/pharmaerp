package DKSPACE.PhamarERP.auth.enums;

import org.apache.poi.ss.formula.functions.Days;

import java.util.*;

import static DKSPACE.PhamarERP.auth.enums.PrivilegeKeyEnum.*;

interface hasPrivileges {
    Map<PrivilegeKeyEnum, String> getPrivilegesMap();
}


public enum PrivilegeGroupEnum {
    Role("Phân quyền", MapUtils.<PrivilegeKeyEnum, String>build().put(
            UPDATE,"chỉnh sửa"
    ).ok()),

    //todo: i18n

    ;


    PrivilegeGroupEnum(String groupName, Map<PrivilegeKeyEnum, String> map) {

    }
}
