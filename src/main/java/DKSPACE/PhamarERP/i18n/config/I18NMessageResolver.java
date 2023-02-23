package DKSPACE.PhamarERP.i18n.config;

import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

import java.io.IOException;

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

    public ApiResponse<?> generateApiResponse(ApiResponseInfo responseInfo, @NotNull HttpServletResponse response)
            throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        final var apiResponse = this.generateApiResponse(ApiResponseInfo.UNAUTHORIZED);
        response.getWriter().write(mapper.writeValueAsString(apiResponse));
        return ApiResponse.failed(responseInfo, this);
    }
}
