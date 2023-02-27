package DKSPACE.PhamarERP.i18n.enums;

public interface GenerateI18NCode {

    default String getI18NCodeForKey() {
        String groupNamePrefix = getI18NCodeForGroup();
        return groupNamePrefix + "." + this.name().toLowerCase();
    }

    //permission.user
    default String getI18NCodeForGroup() {
        return "permission.".concat(GenerateI18NCode.this.getClass()
                                                                  .getSimpleName()
                                                                  .toLowerCase());
    }

    String name();
}