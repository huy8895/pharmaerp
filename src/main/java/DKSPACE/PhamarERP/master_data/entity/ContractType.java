package DKSPACE.PhamarERP.master_data.entity;

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
	
	
	@Size(max = 100)
	@NotNull
	@Column(name = "name_vi", nullable = false, length = 100)
	private String nameVi;
	
	@Size(max = 100)
	@NotNull
	@Column(name = "name_en", nullable = false, length = 100)
	private String nameEn;
	
	@NotNull
	@Column(name = "is_determine_deadline", nullable = false)
	private Boolean isDetermineDeadline = false;
	
	@NotNull
	@Column(name = "is_active", nullable = false)
	private Boolean isActive = false;
	
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	
}