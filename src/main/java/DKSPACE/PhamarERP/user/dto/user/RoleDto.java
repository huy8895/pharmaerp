package DKSPACE.PhamarERP.user.dto.user;

import DKSPACE.PhamarERP.auth.model.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Role} entity
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto implements Serializable {
	private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;
	private String describe;
	@NotNull
	private Boolean isDefault;
	@NotNull
	private Boolean isActive;
	@Size(max = 100)
	@NotNull
	private String nameVi;
	@Size(max = 100)
	@NotNull
	private String nameEn;
}