package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * hoạt động của người dùng trên hệ thống.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activity_logs", indexes = {
		@Index(name = "activity_logs_user_id_idx", columnList = "user_id")
})
public class ActivityLog extends BaseCRUDEntity {
	
	/**
	 * Id người dùng.
	 */
	@NotNull
	@Column(name = "user_id", nullable = false )
	private Long userId;
	
	/**
	 * Địa chỉ IP của người dùng.
	 */
	@Size(max = 20)
	@NotNull
	@Column(name = "ip", nullable = false, length = 20)
	private String ip;
	
	/**
	 * Thông tin về trình duyệt và hệ điều hành của người dùng.
	 */
	@Column(name = "user_agent", length = Integer.MAX_VALUE)
	private String userAgent;
	
	/**
	 * Thông tin về yêu cầu (request) mà người dùng gửi tới hệ thống.
	 * Có thể bao gồm phương thức, đường dẫn, tham số và nội dung yêu cầu.
	 */
	@Column(name = "request", length = Integer.MAX_VALUE)
	private String request;
	
	/**
	 * Thông tin về phản hồi (response) mà hệ thống gửi lại cho người dùng.
	 * Có thể bao gồm mã trạng thái, tiêu đề và nội dung phản hồi.
	 */
	@Column(name = "response", length = Integer.MAX_VALUE)
	private String response;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ActivityLog that = (ActivityLog) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
	
	