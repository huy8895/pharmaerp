package DKSPACE.PhamarERP.i18n.enums;

public interface GenerateI18NCode {

    String PRIVILEGE_GROUP_PREFIX = "privilege.group.";

    default String getPrivilegeKeyName() {
        String groupNamePrefix = getGroupName();
        return groupNamePrefix + "." + this.name().toLowerCase();
    }

    default String getGroupName() {
        return PRIVILEGE_GROUP_PREFIX.concat(GenerateI18NCode.this.getClass()
                                                                  .getSimpleName()
                                                                  .toLowerCase());
    }

    String name();
}