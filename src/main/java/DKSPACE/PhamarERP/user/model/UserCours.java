package DKSPACE.PhamarERP.user.model;

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

import java.time.LocalDate;
import java.util.Objects;

/**
 * đại diện cho một khóa học mà người dùng đã tham gia hoặc đang tham gia.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_courses", indexes = {
		@Index(name = "user_courses_user_id_idx", columnList = "user_id")
})
public class UserCours extends BaseCRUDEntity {
	
	
	/**
	 * Mã người dùng. Không được để trống.
	 */
	@NotNull
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	/**
	 * Tên khóa học. Không được để trống.
	 */
	@Size(max = 255)
	@NotNull
	@Column(name = "name", nullable = false)
	private String name;
	
	/**
	 * Tổ chức cung cấp khóa học. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 255)
	@Column(name = "organization")
	private String organization;
	
	/**
	 * Ngày bắt đầu khóa học. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 45)
	@Column(name = "start_date", length = 45)
	private LocalDate startDate;
	
	/**
	 * Ngày kết thúc khóa học. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 45)
	@Column(name = "end_date", length = 45)
	private LocalDate endDate;
	
	/**
	 * Mô tả về nội dung và mục tiêu của khóa học. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	/**
	 * Đường dẫn tới trang web hoặc tài liệu của khóa học. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 255)
	@Column(name = "link")
	private String link;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		UserCours userCours = (UserCours) o;
		return getId() != null && Objects.equals(getId(), userCours.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}