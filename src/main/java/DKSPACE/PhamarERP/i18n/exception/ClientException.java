package DKSPACE.PhamarERP.i18n.exception;

import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;

public class ClientException extends RuntimeException{
    protected final ApiResponseInfo apiResponseInfo;

    public ClientException(ApiResponseInfo apiResponseInfo) {
        super(apiResponseInfo.name());
        this.apiResponseInfo = apiResponseInfo;
    }

    public ApiResponseInfo getApiResponseInfo() {
        return apiResponseInfo;
    }
}
