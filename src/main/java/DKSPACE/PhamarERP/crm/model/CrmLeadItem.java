package DKSPACE.PhamarERP.crm.model;

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

import java.util.Objects;

/**
 * đại diện cho một sản phẩm của một khách hàng tiềm năng trong hệ thống CRM.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "crm_lead_items", indexes = {
		@Index(name = "crm_lead_items_crm_lead_id_idx", columnList = "crm_lead_id")
})
public class CrmLeadItem extends BaseCRUDEntity {
	
	/**
	 * Khách hàng tiềm năng mà sản phẩm thuộc về. Không được để trống.
	 */
	@NotNull
	@Column(name = "crm_lead_id")
	private Long crmLeadId;
	
	/**
	 * Tên của sản phẩm. Không được để trống.
	 */
	@Size(max = 100)
	@NotNull
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	/**
	 * Màu sắc của sản phẩm. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 10)
	@Column(name = "color", length = 10)
	private String color;
	
	/**
	 * Mô tả về sản phẩm. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	/**
	 * Trạng thái hoạt động của sản phẩm (true: hoạt động; false: ngừng hoạt động).
	 * Mặc định là true khi tạo mới một sản phẩm trong hệ thống CRM.
	 */
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private Boolean isActive = true;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CrmLeadItem that = (CrmLeadItem) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}