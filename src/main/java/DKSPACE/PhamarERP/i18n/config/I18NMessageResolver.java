package DKSPACE.PhamarERP.i18n.config;

import DKSPACE.PhamarERP.auth.enums.permission.HasI18NCode;
import DKSPACE.PhamarERP.helper.excel.ReflectUtils;
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
import org.springframework.validation.FieldError;

import java.io.IOException;
import java.util.Locale;

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

    public ApiResponse<?> generateApiResponse(ApiResponseInfo responseInfo) {
        return ApiResponse.failed(responseInfo, this);
    }

    public void generateApiResponse(ApiResponseInfo responseInfo, @NotNull HttpServletResponse response)
            throws IOException {
        this.responseUnauthorized(response);
    }
    
    public void responseUnauthorized(HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final var unauthorized = HttpStatus.UNAUTHORIZED;
        response.setStatus(unauthorized.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        final var apiResponse = this.generateApiResponse(ApiResponseInfo.UNAUTHORIZED);
        apiResponse.setStatus(unauthorized.name());
        apiResponse.setStatusCode(unauthorized.value());
        response.getWriter().write(mapper.writeValueAsString(apiResponse));
    }

    public String resolverMessageTemplate(FieldError error, Locale locale) {
        if (LANGUAGE_VN.equals(locale.getDisplayLanguage())){
            try {
                return error.getDefaultMessage();
            } catch (Exception e){
                log.error("error resolverMessageTemplate {} {}", e.getClass(), e.getMessage());
                return error.getDefaultMessage();
            }
        }
        return error.getDefaultMessage();
    }

    //exception.getBindingResult().getFieldErrors().get(0).source.messageTemplate
    //messageTemplate = {jakarta.validation.constraints.Size.message}
    private String getDefaultErrorCode(FieldError error) {
        Object source = ReflectUtils.getValue(error, "source", Object.class);
        String messageTemplate = ReflectUtils.getValue(source, "messageTemplate", String.class);
        if (messageTemplate == null || messageTemplate.length() < 2) return "";
        return messageTemplate.substring(1, messageTemplate.length() - 1);
    }
}
