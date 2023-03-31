package DKSPACE.PhamarERP.general.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * chứa thông tin về các tệp tin được tải lên và liên kết với các đối tượng khác trong hệ thống.
 */
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
	
	public UploadableId getId() {
		return id;
	}
	
	public void setId(UploadableId id) {
		this.id = id;
	}
	
	public GenUpload getGenUpload() {
		return genUpload;
	}
	
	public void setGenUpload(GenUpload genUpload) {
		this.genUpload = genUpload;
	}
	
	public String getObjectType() {
		return objectType;
	}
	
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	
	public String getObjectField() {
		return objectField;
	}
	
	public void setObjectField(String objectField) {
		this.objectField = objectField;
	}
	
	public String getDescribe() {
		return describe;
	}
	
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
}