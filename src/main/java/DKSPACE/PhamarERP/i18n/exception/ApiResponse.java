package DKSPACE.PhamarERP.i18n.exception;


import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String status;
    private String message;
     private int statusCode;
    private List<ErrorDTO> errors;
    private T body;

    @JsonIgnore
    private I18NMessageResolver i18NMessageResolver;

    public static <T> ApiResponse<T> ok(@Nullable T body) {
        return ApiResponse.<T>builder()
                          .status(HttpStatus.OK.name())
                          .statusCode(HttpStatus.OK.value())
                          .body(body)
                          .build();
    }
    
    public static <T> ApiResponse<T> failed(List<ErrorDTO> errors, HttpStatus httpStatus) {
        return ApiResponse.<T>builder()
                          .status(httpStatus.name())
                          .statusCode(httpStatus.value())
                          .errors(errors)
                          .build();
    }

    private static String getI18nMessageCheckNull(ApiResponseInfo responseInfo, I18NMessageResolver messageResolver) {
        return messageResolver != null ? messageResolver.convertMessage(responseInfo.getI18NMessageCode()) : responseInfo.name();
    }

    public static ApiResponse<?> failed(ApiResponseInfo responseInfo, @Nullable I18NMessageResolver messageResolver) {
        final var i18nMessage = getI18nMessageCheckNull(responseInfo, messageResolver);
        return ApiResponse.builder()
                          .status("ApiResponseStatus.FAILED")
                          .message(i18nMessage)
                          .build();
    }
}
