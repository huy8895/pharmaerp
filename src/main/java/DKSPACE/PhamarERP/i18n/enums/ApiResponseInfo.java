package DKSPACE.PhamarERP.i18n.enums;

public enum ApiResponseInfo {
    USER_ALREADY_EXIST("error.message.UserAlreadyExist"),
    UNAUTHORIZED("error.message.Unauthorized"),
    BAD_CREDENTIALS("error.message.BadCredentials"),
    BAD_REQUEST("error.message.BadRequest"),
    INTERNAL_SERVER_ERROR("error.message.InternalServerError"),
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