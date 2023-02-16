package DKSPACE.PhamarERP.i18n.dto;


import DKSPACE.PhamarERP.i18n.constants.ValidateCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class GreetingDto {

  @NotNull(message = ValidateCode.NOT_EMPTY)
  private String msg;

  @NotNull(message = ValidateCode.NOT_NULL)
  @Size(min=1, max=3)
  private List<@Valid CategoryDto> categoryDtoList;

}
