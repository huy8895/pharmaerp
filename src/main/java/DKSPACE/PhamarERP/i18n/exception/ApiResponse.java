package DKSPACE.PhamarERP.i18n.exception;


import DKSPACE.PhamarERP.i18n.enums.ApiResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public ApiResponse(ApiResponseStatus status,
                       String message,
                       String code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
