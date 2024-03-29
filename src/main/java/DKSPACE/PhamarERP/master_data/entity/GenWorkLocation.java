package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * đại diện cho một địa điểm làm việc trong hệ thống.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gen_work_locations")
public class GenWorkLocation extends BaseCRUDEntity {
	
	
	/**
	 * Tên tiếng Việt của địa điểm làm việc.
	 */
	@Size(max = 100)
	@NotNull
	@Column(name = "name_vi", nullable = false, length = 100)
	private String nameVi;
	
	/**
	 * Tên tiếng Anh của địa điểm làm việc.
	 */
	@Size(max = 100)
	@NotNull
	@Column(name = "name_en", nullable = false, length = 100)
	private String nameEn;
	
	/**
	 * Mô tả về địa điểm làm việc. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	/**
	 * Biến boolean chỉ ra địa điểm làm việc có hoạt động hay không. Mặc định là false.
	 */
	@NotNull
	@Column(name = "is_active", nullable = false)
	private Boolean isActive = false;
}