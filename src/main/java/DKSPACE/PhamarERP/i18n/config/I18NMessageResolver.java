package DKSPACE.PhamarERP.i18n.config;

import DKSPACE.PhamarERP.auth.enums.permission.HasI18NCode;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class I18NMessageResolver {
    public static final String LANGUAGE_VN = "vn";
    private final MessageSource messageSource;
    public String convertMessage(HasI18NCode hasI18NCode) {
        if (hasI18NCode == null) return "";
        return this.convertMessage(hasI18NCode.getI18nCode());
    }
    
    public String convertMessage(String code) {
        if (code == null) return "";
        final var locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, locale);
    }
    
    public String convertMessage(ApiResponseInfo apiResponseInfo) {
        if (apiResponseInfo == null) return "";
        return this.convertMessage(apiResponseInfo.getI18NMessageCode());
    }
    
    public void generateApiResponse(HttpServletResponse response, HttpStatus httpStatus) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(httpStatus.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        final var apiResponse = this.getApiResponse(httpStatus, ApiResponseInfo.UNAUTHORIZED);
        response.getWriter().write(mapper.writeValueAsString(apiResponse));
    }
    
    public ApiResponse<?> getApiResponse(HttpStatus httpStatus, ApiResponseInfo responseInfo) {
        return ApiResponse.builder()
                          .message(this.convertMessage(responseInfo))
                          .status(httpStatus.name())
                          .statusCode(httpStatus.value())
                          .build();
    }
}
