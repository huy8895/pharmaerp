package DKSPACE.PhamarERP.auth.enums.permission;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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
    DETAIL_USER("permission.user.detail_user"),
    TOGGLE_ACTIVE_USER("permission.user.toggle_active_user"),
    ADD_ROLES_USER("permission.user.add_roles_user"),
    EXPORT_USER("permission.user.export_user"),
    IMPORT_USER("permission.user.import_user"),
    CHANGE_PASSWORD_USER("permission.user.change_password_user"),
    
    //user-profile
    VIEW_USER_PROFILE("permission.user_profile.view"),
    UPDATE_USER_PROFILE("permission.user_profile.update"),
    
    CREATE_JOB_TITLE("permission.job_title.create"),
    IMPORT_JOB_TITLE("permission.job_title.import"),
    DETAIL_JOB_TITLE("permission.job_title.detail"),
    LIST_JOB_TITLE("permission.job_title.list"),
    UPDATE_JOB_TITLE("permission.job_title.update"),
    DELETE_JOB_TITLE("permission.job_title.delete"),
    EXPORT_JOB_TITLE("permission.job_title.export"),

    ;
    
    static {
        groupEnumMap = Arrays.stream(values()).collect(Collectors.toMap(Enum::name, p -> p));
    }
    
    private static final Map<String, PermissionKeyEnum> groupEnumMap;

    private final String i18nCode;

    PermissionKeyEnum(String i18nCode) {

        this.i18nCode = i18nCode;
    }

    public String getI18nCode() {
        return i18nCode;
    }
    
    public static PermissionKeyEnum from(String groupName) {
        return groupEnumMap.get(groupName);
    }
}
