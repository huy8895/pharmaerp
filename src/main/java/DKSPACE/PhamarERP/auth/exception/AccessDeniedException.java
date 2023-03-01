package DKSPACE.PhamarERP.auth.exception;


import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ClientException;

public class AccessDeniedException extends ClientException {


    public AccessDeniedException(ApiResponseInfo apiResponseInfo) {
        super(apiResponseInfo);
    }
}
