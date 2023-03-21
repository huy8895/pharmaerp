package DKSPACE.PhamarERP.auth.enums.permission;

import DKSPACE.PhamarERP.auth.controller.RoleController;
import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.controller.*;
import DKSPACE.PhamarERP.controller.csm.*;
import DKSPACE.PhamarERP.master_data.entity.GenJobTitle;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum.*;


public enum PermissionGroupEnum implements HasI18NCode{
    ROLE(
            RoleController.class,
            "permission.group.role",
            CREATE_ROLE,
            UPDATE_ROLE,
            LIST_ROLE,
            DELETE_ROLE,
            DETAIL_ROLE
    ),

    USER(
            UserController.class,
            "permission.group.user",
            CREATE_USER,
            UPDATE_USER,
            GET_LIST_USER,
            TOGGLE_ACTIVE_USER,
            ADD_ROLES_USER,
            EXPORT_USER,
            IMPORT_USER,
            CHANGE_PASSWORD_USER
            ),
    
    JOB_TITLE(GenJobTitle.class,"permission.group.job_title"),
    ACTIVITY_LOG(ActivityLogController.class, "permission.group.activity_log"),
    CONTRACT(ContractController.class, "permission.group.contract"),
    CONTRACT_TYPE(ContractTypeController.class, "permission.group.contract_type"),
    CRM_COMPANY(CrmCompanyController.class, "permission.group.crm_company"),
    CRM_CONTACT(CrmContactController.class, "permission.group.crm_contact"),
    CRM_LEAD(CrmLeadController.class, "permission.group.crm_lead"),
    CRM_LEAD_ITEM(CrmLeadItemController.class, "permission.group.crm_lead_item"),
    CRM_TAG(CrmTagController.class, "permission.group.crm_tag"),
    GEN_DEPARTMENT(GenDepartmentController.class, "permission.group.gen_department"),
    GEN_JOB_TITLE(GenJobTitleController.class, "permission.group.gen_job_title"),
    GEN_OFFICER_LEVEL(GenOfficerLevelController.class,"permission.group.gen_officer_level"),
    GEN_WORK_LOCATION(GenWorkLocationController.class,"permission.group.gen_work_location"),
    USER_ACTIVITY(UserActivityController.class,"permission.group.user_activity"),
    USER_CERTIFICATE(UserCertificateController.class,"permission.group.user_certificate"),
    USER_COURS(UserCertificateController.class,"permission.group.user_cours")

    ;

    static {
       groupEnumMap = Arrays.stream(values()).collect(Collectors.toMap(Enum::name, p -> p));
    }

    private static final Map<String, PermissionGroupEnum> groupEnumMap;
    private final Class<?> controller;
    private final String i18nCode;
    private final List<HasI18NCode> keys;

    PermissionGroupEnum(Class<?> entityClass, String i18nCode, HasI18NCode... permissionKeyEnums) {
        this.controller = entityClass;
        this.i18nCode = i18nCode;
        this.keys = List.of(permissionKeyEnums);
    }

    public static PermissionGroupEnum from(String groupName) {
        return groupEnumMap.get(groupName);
    }

    public Map<String, PermissionGroupEnum> getGroupEnumMap() {
        return groupEnumMap;
    }

    public HasI18NCode getKey(String key) {
        return this.keys.stream()
                        .filter(i18NCode -> i18NCode.name().equals(key))
                        .findFirst()
                        .orElse(null);
    }

    public List<HasI18NCode> getKeys() {
        return this.keys;
    }

    @Override
    public String getI18nCode() {
        return i18nCode;
    }
    
    
    public boolean isBaseCRUD() {
        return AbstractBaseCRUDController.class.isAssignableFrom(this.controller);
    }
    
    public static Optional<PermissionGroupEnum> getGroup(Class<?> aClass) {
        return Arrays.stream(values()).filter(groupEnum -> groupEnum.controller.equals(aClass))
                     .findFirst();
    }
}
