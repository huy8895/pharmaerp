package DKSPACE.PhamarERP.i18n.enums;

public interface GenerateI18NCode {

    String permission_GROUP_PREFIX = "permission";

    default String getPermissionKeyName() {
        String groupNamePrefix = getGroupName();
        return groupNamePrefix + "." + this.name().toLowerCase();
    }

    default String getGroupName() {
        return "permission".concat(GenerateI18NCode.this.getClass()
                                                                  .getSimpleName()
                                                                  .toLowerCase());
    }

    String name();
}