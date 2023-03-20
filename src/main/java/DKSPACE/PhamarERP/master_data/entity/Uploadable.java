package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.master_data.entity.id.UploadableId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

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
	
	/**
	 * Khóa chính của bản ghi. Bao gồm hai trường: genUploadId và objectId.
	 */
	@EmbeddedId
	private UploadableId id;
	
	/**
	 * Đối tượng GenUpload được liên kết với bản ghi này. Chứa thông tin chi tiết về tệp tin được tải lên.
	 */
	@MapsId("genUploadId")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gen_upload_id", nullable = false)
	private GenUpload genUpload;
	
	/**
	 * Tên bảng của đối tượng được tham chiếu bởi bản ghi này. Ví dụ: users, products...
	 */
	@Size(max = 45)
	@Column(name = "object_type", length = 45)
	private String objectType;
	
	/**
	 * Tên trường của đối tượng được tham chiếu bởi bản ghi này. Ví dụ: logo, avatar...
	 */
	@Size(max = 45)
	@Column(name = "object_field", length = 45)
	private String objectField;
	
	/**
	 * Mô tả về nội dung hoặc chức năng của tệp tin được tải lên. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Uploadable that = (Uploadable) o;
		return id != null && Objects.equals(id, that.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}