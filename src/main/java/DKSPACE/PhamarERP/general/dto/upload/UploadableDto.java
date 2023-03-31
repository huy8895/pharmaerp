package DKSPACE.PhamarERP.general.dto.upload;

import DKSPACE.PhamarERP.general.enums.ObjectField;
import DKSPACE.PhamarERP.general.enums.ObjectType;
import DKSPACE.PhamarERP.general.model.GenUpload;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

/**
 * A DTO for the {@link GenUpload} entity
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadableDto {
	@NotNull
	private ObjectType objectType;
 
	@NotNull
	private ObjectField objectField;
 
	@NotNull
	private Long objectId;
 
	@NotNull
	private Set<Long> genUploadId;
}