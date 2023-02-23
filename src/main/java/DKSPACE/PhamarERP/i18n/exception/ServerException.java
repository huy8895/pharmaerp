package DKSPACE.PhamarERP.i18n.exception;

import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;

public class ServerException extends RuntimeException{
    private final ApiResponseInfo apiResponseInfo;

    public ServerException(ApiResponseInfo apiResponseInfo) {
        super(apiResponseInfo.name());
        this.apiResponseInfo = apiResponseInfo;
    }

    public ApiResponseInfo getApiResponseInfo() {
        return apiResponseInfo;
    }
}
