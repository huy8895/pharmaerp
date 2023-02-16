package DKSPACE.PhamarERP.i18n.exception;


import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private ApiResponseStatus status;
    private String message;
    private String code;
    private List<ErrorDTO> errors;
    private T results;

    @JsonIgnore
    private I18NMessageResolver i18NMessageResolver;

    public static <T> ApiResponse<T> ok(@Nullable T body) {
        return ApiResponse.<T>builder()
                          .status(ApiResponseStatus.SUCCESS)
                          .build();
    }

    private static String getI18nMessageCheckNull(ApiResponseInfo responseInfo, I18NMessageResolver messageResolver) {
        return messageResolver != null ? messageResolver.convertMessage(responseInfo.getI18NMessageCode()) : responseInfo.name();
    }

    public static ApiResponse<?> authenticationFail(ApiResponseInfo responseInfo, @Nullable I18NMessageResolver messageResolver) {
        final var i18nMessage = getI18nMessageCheckNull(responseInfo, messageResolver);
        return ApiResponse.builder()
                          .status(ApiResponseStatus.FAILED)
                          .message(i18nMessage)
                          .build();
    }

    public static ApiResponse<?> failed(ApiResponseInfo responseInfo, @Nullable I18NMessageResolver messageResolver) {
        final var i18nMessage = getI18nMessageCheckNull(responseInfo, messageResolver);
        return ApiResponse.builder()
                          .status(ApiResponseStatus.FAILED)
                          .message(i18nMessage)
                          .build();
    }
}
