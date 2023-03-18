package DKSPACE.PhamarERP.auth.enums.permission;

public enum PermissionKeyEnum implements HasI18NCode{
    //role

    CREATE_ROLE("permission.role.create_role"),
    UPDATE_ROLE("permission.role.update_role"),
    LIST_ROLE("permission.role.list_role"),
    DELETE_ROLE("permission.role.delete_role"),
    DETAIL_ROLE("permission.role.detail_role"),

    //user
    CREATE_USER("permission.user.create_user"),
    UPDATE_USER("permission.user.update_user"),
    GET_LIST_USER("permission.user.get_list_user"),
    TOGGLE_ACTIVE_USER("permission.user.toggle_active_user"),
    ADD_ROLES_USER("permission.user.add_roles_user"),
    EXPORT_USER("permission.user.export_user"),
    IMPORT_USER("permission.user.import_user"),
    CHANGE_PASSWORD_USER("permission.user.change_password_user"),
    
    //user-profile
    VIEW_USER_PROFILE("permission.user_profile.view"),
    UPDATE_USER_PROFILE("permission.user_profile.update"),

    ;


    private final String i18nCode;

    PermissionKeyEnum(String i18nCode) {

        this.i18nCode = i18nCode;
    }

    public String getI18nCode() {
        return i18nCode;
    }
}
