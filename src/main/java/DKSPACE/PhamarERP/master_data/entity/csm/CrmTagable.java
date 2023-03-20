package DKSPACE.PhamarERP.master_data.entity.csm;

import DKSPACE.PhamarERP.master_data.entity.id.TagableId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Lớp Tagable đại diện cho một đối tượng có thể được gán nhãn trong hệ thống CRM. Lớp này có một khóa chính nhúng là TagableId bao gồm id của nhãn và id của đối tượng được gán nhãn.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tagables")
public class CrmTagable {
	
	/**
	 * Khóa chính nhúng của lớp Tagable. Bao gồm id của nhãn và id của đối tượng được gán nhãn.
	 */
	@EmbeddedId
	private TagableId id;
	
	/**
	 * Loại của đối tượng được gán nhãn. Ví dụ: công ty, liên hệ, khách hàng tiềm năng... Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 45)
	@Column(name = "object_type", length = 45)
	private String objectType;
	
	/**
	 * Trường của đối tượng được gán nhãn. Ví dụ: tên, email, số điện thoại... Có thể để trống nếu không có thông tin.
	 */
	@Size(max = 45)
	@Column(name = "object_field", length = 45)
	private String objectField;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CrmTagable crmTagable = (CrmTagable) o;
		return id != null && Objects.equals(id, crmTagable.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}