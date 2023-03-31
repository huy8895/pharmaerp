package DKSPACE.PhamarERP.general.model;

import DKSPACE.PhamarERP.general.enums.ObjectField;
import DKSPACE.PhamarERP.general.enums.ObjectType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@IdClass(UploadableId.class)
public class Uploadable {
	
	/**
	 * Khóa chính của bản ghi. Bao gồm hai trường: genUploadId và objectId.
	 */
	@Id
	@NotNull
	@Column(name = "gen_upload_id", nullable = false)
	private Long genUploadId;
	
	@Id
	@Basic
	@NotNull
	@Column(name = "object_id", nullable = false)
	private Long objectId;
	
	/**
	 * Đối tượng GenUpload được liên kết với bản ghi này. Chứa thông tin chi tiết về tệp tin được tải lên.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "gen_upload_id", referencedColumnName = "id"),
			@JoinColumn(name = "object_id", referencedColumnName = "id")
	})
	private GenUpload genUpload;
	
	/**
	 * Tên bảng của đối tượng được tham chiếu bởi bản ghi này. Ví dụ: users, products...
	 */
	@Size(max = 45)
	@Column(name = "object_type", length = 45)
	@Enumerated(EnumType.STRING)
	private ObjectType objectType;
	
	/**
	 * Tên trường của đối tượng được tham chiếu bởi bản ghi này. Ví dụ: logo, avatar...
	 */
	@Size(max = 45)
	@Column(name = "object_field", length = 45)
	@Enumerated(EnumType.STRING)
	private ObjectField objectField;
	
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
		return genUploadId != null && Objects.equals(genUploadId, that.genUploadId)
				&& objectId != null && Objects.equals(objectId, that.objectId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(genUploadId, objectId);
	}
}