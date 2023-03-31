package DKSPACE.PhamarERP.warehouse.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.basecrud.Toggleable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "warehouse_areas")
@JsonIgnoreProperties(value = "isActive", allowGetters = true)
public class WarehouseArea extends BaseCRUDEntity implements Toggleable {
	
	@ManyToOne
	@JoinColumn(name = "warehouse_id", referencedColumnName = "id")
	private Warehouse warehouse;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "name_vi", nullable = false)
	private String nameVi;
	
	@Size(max = 255)
	@Column(name = "name_en")
	private String nameEn;
	
	@Size(max = 45)
	@Column(name = "warehouse_area_code")
	private String warehouseAreaCode;
	
	@Column(name = "describe")
	private String describe;
	
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private Boolean isActive = true;
	
	@PastOrPresent
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@PastOrPresent
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@PastOrPresent
	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		WarehouseArea that = (WarehouseArea) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}