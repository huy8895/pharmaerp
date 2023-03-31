package DKSPACE.PhamarERP.supplier.model;

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

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers", indexes = {
		@Index(name = "suppliers_tax_code_unique", columnList = "tax_code", unique = true)
})
public class Supplier extends BaseCRUDEntity {
	
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
	
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private Boolean isActive = true;
}