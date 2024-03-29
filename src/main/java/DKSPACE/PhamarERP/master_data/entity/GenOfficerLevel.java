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
 * đại diện cho một cấp bậc cán bộ trong hệ thống.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gen_officer_levels")
public class GenOfficerLevel extends BaseCRUDEntity {
	
	/**
	 * Tên tiếng Việt của cấp bậc cán bộ.
	 */
	@Size(max = 100)
	@NotNull
	@Column(name = "name_vi", nullable = false, length = 100)
	private String nameVi;
	
	/**
	 * Tên tiếng Anh của cấp bậc cán bộ.
	 */
	@Size(max = 100)
	@NotNull
	@Column(name = "name_en", nullable = false, length = 100)
	private String nameEn;
	
	/**
	 * Mô tả về cấp bậc cán bộ. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	/**
	 * Biến boolean chỉ ra cấp bậc cán bộ có hoạt động hay không. Mặc định là false.
	 */
	@NotNull
	@Column(name = "is_active", nullable = false)
	private Boolean isActive = false;
}