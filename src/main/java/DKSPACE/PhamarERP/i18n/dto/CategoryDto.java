package DKSPACE.PhamarERP.i18n.dto;


import DKSPACE.PhamarERP.i18n.constants.ValidateCode;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryDto {

  @NotNull(message = ValidateCode.NOT_NULL)
  private String name;

  @NotEmpty(message = ValidateCode.NOT_EMPTY)
  private String type;

}
