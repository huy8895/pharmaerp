package DKSPACE.PhamarERP.material.model;

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
@Table(name = "material_groups", indexes = {
		@Index(name = "material_groups_name_vi_unique", columnList = "name_vi", unique = true)
})
public class MaterialGroup extends BaseCRUDEntity {
	
	@Size(max = 100)
	@NotNull
	@Column(name = "name_vi", nullable = false, length = 100)
	private String nameVi;
	
	@Size(max = 100)
	@Column(name = "name_en", length = 100)
	private String nameEn;
	
	@Size(max = 45)
	@NotNull
	@Column(name = "type", nullable = false, length = 45)
	private String type;
	
	@Column(name = "is_active")
	private Boolean isActive;
}