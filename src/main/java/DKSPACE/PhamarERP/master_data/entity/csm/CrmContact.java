package DKSPACE.PhamarERP.master_data.entity.csm;

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

import java.util.Objects;

/**
 * đại diện cho một liên hệ của một công ty trong hệ thống CRM.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "crm_contacts")
public class CrmContact extends BaseCRUDEntity {
	
	/**
	 * Công ty mà liên hệ thuộc về. Không được để trống.
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "crm_company_id", nullable = false)
	private CrmCompany crmCompany;
	
	/**
	 * Email của liên hệ. Không được để trống.
	 */
	@Size(max = 100)
	@NotNull
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	/**
	 * Số điện thoại của liên hệ. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 20)
	@Column(name = "tel", length = 20)
	private String tel;
	
	/**
	 * Tên của liên hệ. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 50)
	@Column(name = "first_name", length = 50)
	private String firstName;
	
	/**
	 * Họ của liên hệ. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 50)
	@Column(name = "last_name", length = 50)
	private String lastName;
	
	/**
	 * Tên tiếng Anh của liên hệ. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 50)
	@Column(name = "english_name", length = 50)
	private String englishName;
	
	/**
	 * Chức vụ của liên hệ trong công ty. Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 100)
	@Column(name = "designation", length = 100)
	private String designation;
	
	/**
	 * Trạng thái hoạt động của liên hệ (true: hoạt động; false: ngừng hoạt động). Mặc định là true khi tạo mới một liên hệ trong hệ thống CRM.
	 */
	@Column(name = "is_active")
	private Boolean isActive;
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CrmContact that = (CrmContact) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}