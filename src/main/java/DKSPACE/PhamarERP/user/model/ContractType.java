package DKSPACE.PhamarERP.user.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.i18n.validation.Unique;
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
 * Lớp ContractType kế thừa từ lớp BaseCRUDEntity. Lớp này đại diện cho một loại hợp đồng trong hệ thống.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract_types", indexes = {
		@Index(name = "name_vi_unique", columnList = "name_vi", unique = true),
		@Index(name = "name_en_unique", columnList = "name_en", unique = true)
})
public class ContractType extends BaseCRUDEntity {
	
	
	/**
	 * Tên tiếng Việt của loại hợp đồng.
	 */
	@Size(max = 100)
	@NotNull
	@Unique(value = ContractType_.NAME_VI, domainClass = ContractType.class)
	@Column(name = "name_vi", nullable = false, length = 100)
	private String nameVi;
	
	/**
	 * Tên tiếng Anh của loại hợp đồng.
	 */
	@NotNull
	@Size(max = 100)
	@Unique(value = ContractType_.NAME_EN, domainClass = ContractType.class)
	@Column(name = "name_en", nullable = false, length = 100)
	private String nameEn;
	
	/**
	 * Biến boolean chỉ ra loại hợp đồng có xác định thời hạn hay không. Mặc định là false.
	 */
	@NotNull
	@Column(name = "is_determine_deadline", nullable = false)
	private Boolean isDetermineDeadline = false;
	
	/**
	 * Biến boolean chỉ ra loại hợp đồng có hoạt động hay không. Mặc định là false.
	 */
	@NotNull
	@Column(name = "is_active", nullable = false)
	private Boolean isActive = true;
	
	/**
	 * Mô tả về loại hợp đồng. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ContractType that = (ContractType) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}