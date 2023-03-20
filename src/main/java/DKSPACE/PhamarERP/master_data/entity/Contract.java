package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.*;
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
 * đại diện cho một hợp đồng của người dùng với hệ thống.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contracts", indexes = {
		@Index(name = "contracts_user_id_unique", columnList = "user_id", unique = true),
		@Index(name = "contracts_gen_job_title_id_idx", columnList = "gen_job_title_id"),
		@Index(name = "contracts_contract_type_id_idx", columnList = "contract_type_id"),
		@Index(name = "contracts_creator_id_idx", columnList = "creator_id"),
		@Index(name = "contracts_gen_work_location_id_idx", columnList = "gen_work_location_id"),
		@Index(name = "contracts_gen_officer_level_id_idx", columnList = "gen_officer_level_id")
})
public class Contract extends BaseCRUDEntity {
	
	/**
	 * Mã người dùng.
	 */
	@NotNull
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	/**
	 * Người tạo hợp đồng. Là một đối tượng của lớp User.
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "creator_id", nullable = false)
	private User creator;
	
	/**
	 * Loại hợp đồng. Là một đối tượng của lớp ContractType.
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "contract_type_id", nullable = false)
	private ContractType contractType;
	
	/**
	 * Địa điểm làm việc. Là một đối tượng của lớp GenWorkLocation.
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gen_work_location_id", nullable = false)
	private GenWorkLocation genWorkLocation;
	
	/**
	 * Cấp bậc cán bộ. Là một đối tượng của lớp GenOfficerLevel.
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gen_officer_level_id", nullable = false)
	private GenOfficerLevel genOfficerLevel;
	
	/**
	 * Mã phòng ban.
	 */
	@NotNull
	@Column(name = "gen_department_id", nullable = false)
	private Long genDepartmentId;
	
	/**
	 * Chức danh công việc. Là một đối tượng của lớp GenJobTitle.
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gen_job_title_id", nullable = false)
	private GenJobTitle genJobTitle;
	
	/**
	 * Mã hợp đồng.
	 */
	@Size(max = 45)
	@NotNull
	@Column(name = "contract_code", nullable = false, length = 45)
	private String contractCode;
	
	/**
	 * Thời hạn của hợp đồng. Được tính bằng ngày. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "duration")
	private Long duration;
	
	/**
	 * Ngày bắt đầu của hợp đồng. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "start_date")
	private LocalDate startDate;
	
	/**
	 * Ngày kết thúc của hợp đồng. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "end_date")
	private LocalDate endDate;
	
	/**
	 * Trạng thái của hợp đồng. Có thể là chưa ký, đã ký, đã duyệt hoặc đã hủy.
	 */
	@Size(max = 45)
	@NotNull
	@Column(name = "status", nullable = false, length = 45)
	private String status;
	
	/**
	 * Ghi chú về hợp đồng. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "note", length = Integer.MAX_VALUE)
	private String note;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Contract contract = (Contract) o;
		return getId() != null && Objects.equals(getId(), contract.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}