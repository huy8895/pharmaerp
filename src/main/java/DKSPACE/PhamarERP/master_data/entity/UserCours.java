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
	private String startDate;
	
	/**
	 * Ngày kết thúc khóa học. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 45)
	@Column(name = "end_date", length = 45)
	private String endDate;
	
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
}