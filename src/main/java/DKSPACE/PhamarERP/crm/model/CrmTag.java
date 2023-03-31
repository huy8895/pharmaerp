package DKSPACE.PhamarERP.crm.model;

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
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * đại diện cho một nhãn trong hệ thống CRM.
 * Nhãn có thể được gán cho các đối tượng khác nhau như công ty, liên hệ, khách hàng tiềm năng, sản phẩm...
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tags")
public class CrmTag extends BaseCRUDEntity {
	
	/**
	 * Tên của nhãn. Không được để trống.
	 */
	@Size(max = 100)
	@NotNull
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	/**
	 * Trạng thái hoạt động của nhãn (true: hoạt động; false: ngừng hoạt động).
	 * Mặc định là true khi tạo mới một nhãn trong hệ thống CRM.
	 */
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private Boolean isActive = true;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CrmTag crmTag = (CrmTag) o;
		return getId() != null && Objects.equals(getId(), crmTag.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}