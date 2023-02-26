package DKSPACE.PhamarERP.i18n.enums;

public enum PrivilegeGroupNameI18N {
    ROLE("privilege.group.name.user"),
    USER("privilege.group.name.role"),

    ;

    private final String i18NMessageCode;

    PrivilegeGroupNameI18N(String i18NMessageCode) {
        this.i18NMessageCode = i18NMessageCode;
    }


    public String getI18NMessageCode() {
        return i18NMessageCode;
    }

    public String getApiResponseCode() {
        return this.name();
    }
}
