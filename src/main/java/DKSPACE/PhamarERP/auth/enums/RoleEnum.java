package DKSPACE.PhamarERP.auth.enums;

public enum RoleEnum {
    ROLE_ADMIN("Quản trị viên"),
    ROLE_USER("Người dùng");

    private final String nameVi;

    RoleEnum(String nameVi) {
        this.nameVi = nameVi;
    }


    public String getNameVi() {
        return nameVi;
    }
}
