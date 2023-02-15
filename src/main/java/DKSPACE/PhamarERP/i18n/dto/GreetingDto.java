package DKSPACE.PhamarERP.i18n.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class GreetingDto {

  @NotEmpty(message = "validation.message.NotEmpty")
  private String msg;

  @NotNull(message = "validation.message.NotEmpty")
  @Size(min=1, max=3)
  private List<@Valid CategoryDto> categoryDtoList;

}
