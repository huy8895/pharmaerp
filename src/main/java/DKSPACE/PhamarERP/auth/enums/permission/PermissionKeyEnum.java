package DKSPACE.PhamarERP.auth.enums.permission;

public enum PermissionKeyEnum implements HasI18NCode{
    CREATE_ROLE("permission.role.create_role"),
    UPDATE_ROLE("permission.role.update_role"),

    CREATE_USER("permission.user.create_user"),
    UPDATE_USER("permission.user.update_user"),
    ;


    private final String i18nCode;

    PermissionKeyEnum(String i18nCode) {

        this.i18nCode = i18nCode;
    }

    public String getI18nCode() {
        return i18nCode;
    }
}
