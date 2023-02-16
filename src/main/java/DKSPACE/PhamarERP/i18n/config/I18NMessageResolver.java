package DKSPACE.PhamarERP.i18n.config;

import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@Slf4j
@RequiredArgsConstructor
public class I18NMessageResolver {
    private final MessageSource messageSource;

    public String convertMessage(String code) {
        if (code == null) return "";
        final var locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, locale);
    }

    public ApiResponse<?> generateApiResponse(ApiResponseInfo responseInfo) {
        return ApiResponse.failed(responseInfo, this);
    }
}
