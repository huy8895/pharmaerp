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
 * đại diện cho một bản ghi chứng chỉ của người dùng trong hệ thống.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_certificates", indexes = {
		@Index(name = "user_certificates_user_id_idx", columnList = "user_id")
})
public class UserCertificate extends BaseCRUDEntity {
	
	
	/**
	 * Mã người dùng.
	 */
	@NotNull
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	/**
	 * Tên chứng chỉ.
	 */
	@Size(max = 255)
	@NotNull
	@Column(name = "name", nullable = false)
	private String name;
	
	/**
	 * Tên tổ chức cấp chứng chỉ.
	 * Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 255)
	@Column(name = "organization")
	private String organization;
	
	/**
	 * Trạng thái có hết hạn hay không của chứng chỉ.
	 * Nếu là true, có nghĩa là chứng chỉ không có ngày hết hạn.
	 * Nếu là false, có nghĩa là chứng chỉ có ngày hết hạn.
	 */
	@Column(name = "has_no_expiration_date")
	private Boolean hasNoExpirationDate;
	
	/**
	 * Ngày bắt đầu có hiệu lực của chứng chỉ. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 45)
	@Column(name = "start_date", length = 45)
	private String startDate;
	
	/**
	 * Ngày kết thúc hiệu lực của chứng chỉ. Có thể để trống nếu không có thông tin hoặc không có ngày hết hạn.
	 */
	@Size(max = 45)
	@Column(name = "end_date", length = 45)
	private String endDate;
	
	/**
	 * Đường dẫn liên kết tới trang web hay mạng xã hội của tổ chức cấp chứng chỉ hoặc tải xuống file chứng chỉ.
	 * Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 255)
	@Column(name = "link")
	private String link;
}