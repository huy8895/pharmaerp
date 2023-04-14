package DKSPACE.PhamarERP.material.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.basecrud.Toggleable;
import DKSPACE.PhamarERP.i18n.validation.Uniques;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
@Table(name = "materials", indexes = {
		@Index(name = "materials_name_vi_unique", columnList = "name_vi", unique = true)
})
@JsonIgnoreProperties(value = "isActive", allowGetters = true)
@Uniques(values = {Material_.NAME_VI}, domainClass = Material.class)
public class Material extends BaseCRUDEntity implements Toggleable {
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gen_unit_id", nullable = false)
	private GenUnit genUnit;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "material_group_id", nullable = false)
	private MaterialGroup materialGroup;
	
	@Size(max = 100)
	@NotNull
	@Column(name = "name_vi", nullable = false, length = 100)
	private String nameVi;
	
	@Size(max = 100)
	@Column(name = "name_en", length = 100)
	private String nameEn;
	
	@Size(max = 255)
	@Column(name = "name_science")
	private String nameScience;
	
	@Column(name = "name_other", length = Integer.MAX_VALUE)
	private String nameOther;
	
	@NotNull
	@Column(name = "inventory_min", nullable = false)
	private Long inventoryMin;
	
	@NotNull
	@Column(name = "inventory_max", nullable = false)
	private Long inventoryMax;
	
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private Boolean isActive = true;
}