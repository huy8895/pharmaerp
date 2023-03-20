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
	
	
	@Size(max = 20)
	@NotNull
	@Column(name = "tax_code", nullable = false, length = 20)
	private String taxCode;
	
	@Size(max = 255)
	@Column(name = "company_name_vi")
	private String companyNameVi;
	
	@Size(max = 255)
	@Column(name = "company_name_en")
	private String companyNameEn;
	
	@Size(max = 100)
	@Column(name = "company_ceo", length = 100)
	private String companyCeo;
	
	@Size(max = 255)
	@Column(name = "abbreviation_name")
	private String abbreviationName;
	
	@Size(max = 45)
	@Column(name = "headquarter", length = 45)
	private String headquarter;
	
	@Size(max = 20)
	@Column(name = "main_tel", length = 20)
	private String mainTel;
	
	@Size(max = 20)
	@Column(name = "main_fax", length = 20)
	private String mainFax;
	
	@Size(max = 100)
	@Column(name = "main_email", length = 100)
	private String mainEmail;
	
	@Column(name = "operation_day")
	private LocalDate operationDay;
	
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