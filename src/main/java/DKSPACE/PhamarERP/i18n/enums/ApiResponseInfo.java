package DKSPACE.PhamarERP.i18n.enums;

public enum ApiResponseInfo {
    USER_ALREADY_EXIST("error.message.USER_ALREADY_EXIST"),
    ;

    private final String i18NMessageCode;

    ApiResponseInfo(String i18NMessageCode) {
        this.i18NMessageCode = i18NMessageCode;
    }


    public String getI18NMessageCode() {
        return i18NMessageCode;
    }

    public String getApiResponseCode() {
        return this.name();
    }
}
