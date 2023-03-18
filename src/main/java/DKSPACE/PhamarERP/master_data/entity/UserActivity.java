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
 * Lớp UserActivity kế thừa từ lớp BaseCRUDEntity. Lớp này đại diện cho một bản ghi hoạt động của người dùng trong một tổ chức nào đó.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_activities", indexes = {
		@Index(name = "user_activities_user_id_idx", columnList = "user_id")
})

public class UserActivity extends BaseCRUDEntity {
	
	/**
	 * Mã người dùng.
	 */
	@NotNull
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	/**
	 * Tên tổ chức mà người dùng tham gia hoặc đã tham gia.
	 */
	@Size(max = 255)
	@NotNull
	@Column(name = "organization", nullable = false)
	private String organization;
	
	/**
	 * Vị trí hoặc vai trò của người dùng trong tổ chức. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 255)
	@Column(name = "participating_position")
	private String participatingPosition;
	
	/**
	 * Trạng thái hiện tại của người dùng trong tổ chức.
	 * Nếu là true, có nghĩa là người dùng vẫn đang hoạt động.
	 * Nếu là false, có nghĩa là người dùng đã rời khỏi tổ chức.
	 */
	@Column(name = "is_current_active")
	private Boolean isCurrentActive;
	
	/**
	 * Ngày bắt đầu tham gia tổ chức. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 45)
	@Column(name = "start_date", length = 45)
	private String startDate;
	
	/**
	 * Ngày kết thúc hoặc rời khỏi tổ chức. Có thể để trống nếu không có thông tin hoặc vẫn còn hoạt động.
	 */
	@Size(max = 45)
	@Column(name = "end_date", length = 45)
	private String endDate;
	
	/**
	 * Mô tả về các công việc hoặc thành tích của người dùng trong tổ chức. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	/**
	 * Đường dẫn liên kết tới trang web hay mạng xã hội của tổ chức. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 255)
	@Column(name = "link")
	private String link;
}