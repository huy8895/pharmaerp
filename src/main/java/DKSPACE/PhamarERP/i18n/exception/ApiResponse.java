package DKSPACE.PhamarERP.i18n.exception;


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
    private ApiResponseInfo responseInfo;

    public static <T> ApiResponse<T> ok(@Nullable T body) {
        return ApiResponse.<T>builder()
                          .status(HttpStatus.OK.name())
                          .statusCode(HttpStatus.OK.value())
                          .body(body)
                          .build();
    }
    
    public static ApiResponse<?> failed(ApiResponseInfo responseInfo){
        return ApiResponse.builder()
                          .responseInfo(responseInfo)
                          .build();
    }
    
    public static <T> ApiResponse<T> failed(List<ErrorDTO> errors, HttpStatus httpStatus) {
        return ApiResponse.<T>builder()
                          .status(httpStatus.name())
                          .statusCode(httpStatus.value())
                          .errors(errors)
                          .build();
    }
}
