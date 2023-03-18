package DKSPACE.PhamarERP.master_data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "uploadables")
public class Uploadable {
	
	@EmbeddedId
	private UploadableId id;
	
	@MapsId("genUploadId")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gen_upload_id", nullable = false)
	private GenUpload genUpload;
	
	@Size(max = 45)
	@Column(name = "object_type", length = 45)
	private String objectType;
	
	@Size(max = 45)
	@Column(name = "object_field", length = 45)
	private String objectField;
	
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
}