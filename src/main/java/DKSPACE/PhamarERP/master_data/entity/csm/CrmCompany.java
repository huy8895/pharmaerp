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

import java.time.LocalDate;
import java.util.Objects;

/**
 * đại diện cho một công ty trong hệ thống CRM.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "crm_companies", indexes = {
		@Index(name = "crm_companies_tax_code_unique", columnList = "tax_code", unique = true)
})
public class CrmCompany extends BaseCRUDEntity {
	
	/**
	 * Mã số thuế của công ty.
	 */
	@NotNull
	@Size(max = 20)
	@Column(name = "tax_code", nullable = false, length = 20)
	private String taxCode;
	
	/**
	 * Tên công ty bằng tiếng Việt. 
	 */
	@Size(max = 255)
	@Column(name = "company_name_vi")
	private String companyNameVi;
	
	/**
	 * Tên công ty bằng tiếng Anh. 
	 */
	@Size(max = 255)
	@Column(name = "company_name_en")
	private String companyNameEn;
	
	/**
	 * Tên giám đốc điều hành của công ty. 
	 */
	@Size(max = 100)
	@Column(name = "company_ceo", length = 100)
	private String companyCeo;
	
	/**
	 * Tên viết tắt của công ty. 
	 */
	@Size(max = 255)
	@Column(name = "abbreviation_name")
	private String abbreviationName;
	
	/**
	 * Trụ sở chính của công ty. 
	 */
	@Size(max = 45)
	@Column(name = "headquarter", length = 45)
	private String headquarter;
	
	/**
	 * Số điện thoại chính của công ty. 
	 */
	@Size(max = 20)
	@Column(name = "main_tel", length = 20)
	private String mainTel;
	
	/**
	 * Số fax chính của công ty. 
	 */
	@Size(max = 20)
	@Column(name = "main_fax", length = 20)
	private String mainFax;
	
	/**
	 * Email chính của công ty. 
	 */
	@Size(max = 100)
	@Column(name = "main_email", length = 100)
	private String mainEmail;
	
	/**
	 * Ngày bắt đầu hoạt động của công ty. 
	 */
	@Column(name = "operation_day")
	private LocalDate operationDay;
	
	/**
	 * Trạng thái hoạt động của công ty (true: hoạt động; false: ngừng hoạt động). 
	 * Mặc định là true khi tạo mới một công ty trong hệ thống CRM.
	 */
	@Column(name = "is_active")
	private Boolean isActive;
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CrmCompany that = (CrmCompany) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}