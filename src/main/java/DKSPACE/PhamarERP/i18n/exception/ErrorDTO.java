package DKSPACE.PhamarERP.i18n.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private String field;
    private String errorMessage;
}
