package DKSPACE.PhamarERP.general.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.i18n.validation.Unique;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * đại diện cho một tệp tin được tải lên hệ thống.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@Accessors(chain = true)
@AllArgsConstructor
@Entity
@Table(name = "gen_uploads", indexes = {
		@Index(name = "original_name_UNIQUE", columnList = "original_name", unique = true)
})
public class GenUpload extends BaseCRUDEntity {
	
	/**
	 * Tên gốc của tệp tin.
	 */
	@Size(max = 255)
	@Unique(value = GenUpload_.ORIGINAL_NAME, domainClass = GenUpload.class)
	@NotNull
	@Column(name = "original_name", nullable = false)
	private String originalName;
	
	/**
	 * Tên của tệp tin sau khi được mã hóa. Có độ dài 45 ký tự.
	 */
	@Size(max = 45)
	@NotNull
	@Column(name = "file_name", nullable = false, length = 45)
	private String fileName;
	
	/**
	 * Phần mở rộng của tệp tin. Có độ dài 10 ký tự.
	 */
	@Size(max = 10)
	@NotNull
	@Column(name = "extension", nullable = false, length = 10)
	private String extension;
	
	/**
	 * Loại nội dung của tệp tin. Ví dụ: image/jpeg, application/pdf, text/plain...
	 */
	@Size(max = 255)
	@NotNull
	@Column(name = "content_type", nullable = false)
	private String contentType;
	
	/**
	 * Dữ liệu của tệp tin. Được lưu trữ dưới dạng mảng byte.
	 */
	@NotNull
	@Column(name = "data", nullable = false)
	private byte[] data;
	
	/**
	 * Kích thước của tệp tin. Được tính bằng megabyte (MB).
	 */
	@NotNull
	@Column(name = "size", nullable = false)
	private Float size;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		GenUpload genUpload = (GenUpload) o;
		return getId() != null && Objects.equals(getId(), genUpload.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}