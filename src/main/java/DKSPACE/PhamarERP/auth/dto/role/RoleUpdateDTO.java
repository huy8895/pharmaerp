package DKSPACE.PhamarERP.auth.dto.role;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

/**
 * A DTO for the {@link DKSPACE.PhamarERP.auth.model.Role} entity
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleUpdateDTO {
    @NotNull
    private Long id;

    @Size(max = 100)
    @NotNull
    private String nameVi;

    @Size(max = 100)
    @NotNull
    private String nameEn;

    private String describe;

    private List<Long> permissionsId;
}