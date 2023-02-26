package DKSPACE.PhamarERP.i18n.enums;

public enum PrivilegeKeyI18N {
    ROLE_CREATE("privilege.key.role_create"),
    ROLE_UPDATE("privilege.key.role_update"),
    USER_UPDATE("privilege.key.user_update"),

    ;

    private final String i18NMessageCode;

    PrivilegeKeyI18N(String i18NMessageCode) {
        this.i18NMessageCode = i18NMessageCode;
    }


    public String getI18NMessageCode() {
        return i18NMessageCode;
    }

    public String getApiResponseCode() {
        return this.name();
    }
}
