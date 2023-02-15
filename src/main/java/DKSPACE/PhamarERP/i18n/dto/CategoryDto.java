package DKSPACE.PhamarERP.i18n.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CategoryDto {

  @NotEmpty(message = "validation.message.NotEmpty")
  private String name;

  @NotEmpty(message = "validation.message.NotEmpty")
  private String type;

}
