package DKSPACE.PhamarERP.i18n.enums;

public interface GenerateI18NCode {
    default String getPrivilegeGroupName() {
        String prefix = "privilege.group.";
        String groupNameI18N = prefix.concat(GenerateI18NCode.this.getClass()
                                                                  .getSimpleName()
                                                                  .toLowerCase());
        return groupNameI18N;
    }

    default String getPrivilegeKeyName() {
        return getPrivilegeGroupName() + "." + this.name()
                                                   .toLowerCase();
    }

    String name();


}