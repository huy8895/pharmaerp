package DKSPACE.PhamarERP.auth.dto.role;

import DKSPACE.PhamarERP.auth.dto.permission.PermissionDTO;
import DKSPACE.PhamarERP.i18n.validation.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link DKSPACE.PhamarERP.auth.model.Role} entity
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDTO implements Serializable {
    private Long id;
    private String describe;

    @Size(max = 100)
    @NotNull
    private String nameVi;

    @Size(max = 100)
    @NotNull
    private String nameEn;

    private List<PermissionDTO> permissions;
}