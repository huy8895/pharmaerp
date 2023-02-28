package DKSPACE.PhamarERP.i18n.enums;

public enum ApiResponseInfo {
    USER_ALREADY_EXIST("error.message.UserAlreadyExist"),
    UNAUTHORIZED("error.message.Unauthorized"),
    BAD_CREDENTIALS("error.message.BadCredentials"),
    BAD_REQUEST("error.message.BadRequest"),
    INTERNAL_SERVER_ERROR("error.message.InternalServerError"),
    INVALID_EXCEL_FILE("error.message.InvalidExcelFile"),
    ERROR_EXPORT_FILE("error.message.ErrorExportFile"),

    NO_VALUE_PRESENT("error.message.NoValuePresent"),
    MAX_UPLOAD_SIZE_EXCEEDED("error.message.MaxUploadSizeExceeded"),

    METHOD_NOT_SUPPORTED("error.message.MethodNotSupported"),

    ROLE_ALREADY_ASSIGN("error.message.RoleAlreadyAssign")
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
