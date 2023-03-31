package DKSPACE.PhamarERP.general.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.basecrud.Toggleable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Lớp này đại diện cho một chức danh công việc trong hệ thống.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gen_job_titles")
@JsonIgnoreProperties(value = "isActive", allowGetters = true)
public class GenJobTitle extends BaseCRUDEntity implements Toggleable {
	
	/**
	 * Tên tiếng Việt của chức danh công việc.
	 */
	@Size(max = 100)
	@NotNull
	@Column(name = "name_vi", nullable = false, length = 100)
	private String nameVi;
	
	/**
	 * Tên tiếng Anh của chức danh công việc.
	 */
	@Size(max = 100)
	@NotNull
	@Column(name = "name_en", nullable = false, length = 100)
	private String nameEn;
	
	/**
	 * Mức lương của chức danh công việc. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "salary")
	private Long salary;
	
	/**
	 * Mô tả về chức danh công việc. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	/**
	 * Biến boolean chỉ ra chức danh công việc có hoạt động hay không. Mặc định là false.
	 */
	@NotNull
	@Column(name = "is_active", nullable = false)
	private Boolean isActive = true;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		GenJobTitle that = (GenJobTitle) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}