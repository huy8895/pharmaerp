package DKSPACE.PhamarERP.master_data.entity.csm;

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
 * Lớp CrmLead kế thừa từ lớp BaseCRUDEntity. Lớp này đại diện cho một khách hàng tiềm năng trong hệ thống CRM.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "crm_leads", indexes = {
		@Index(name = "crm_leads_name_unique", columnList = "name", unique = true)
})
public class CrmLead extends BaseCRUDEntity {
	
	/**
	 * Tên của khách hàng tiềm năng. Không được để trống.
	 */
	@Size(max = 100)
	@NotNull
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	/**
	 * Mô tả về khách hàng tiềm năng. Có thể để trống nếu không có thông tin.
	 */
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	/**
	 * Trạng thái hoạt động của khách hàng tiềm năng (true: hoạt động; false: ngừng hoạt động). Mặc định là true khi tạo mới một khách hàng tiềm năng trong hệ thống CRM.
	 */
	@Column(name = "is_active")
	private Boolean isActive;
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CrmLead crmLead = (CrmLead) o;
		return getId() != null && Objects.equals(getId(), crmLead.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}