package DKSPACE.PhamarERP.auth.enums;

public enum RoleEnum {
    HR("Nhân sự", "HR"),
    ;

    private final String nameVi;
    private final String nameEn;

    RoleEnum(String nameVi, String nameEn) {
        this.nameVi = nameVi;
        this.nameEn = nameEn;
    }


    public String getNameVi() {
        return nameVi;
    }

    public String getNameEn() {
        return nameEn;
    }
}
