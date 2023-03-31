package DKSPACE.PhamarERP.warehouse.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "warehouses")
public class Warehouse extends BaseCRUDEntity {
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "name_vi", nullable = false)
	private String nameVi;
	
	@Size(max = 255)
	@Column(name = "name_en")
	private String nameEn;
	
	@Size(max = 45)
	@Column(name = "warehouse_code")
	private String warehouseCode;
	
	@Column(name = "describe")
	private String describe;
	
	// Quy mô nhà kho, đơn vị là m2
	@PositiveOrZero
	@Column(name = "size")
	private Long size;
	
	// Chiều cao đơn vị mét
	@PositiveOrZero
	@Column(name = "height")
	private Long height;
	
	// Chiều rộng đơn vị mét
	@PositiveOrZero
    @Column(name = "width")
    private Long width;
    
    // Chiều dài đơn vị mét
    @PositiveOrZero
    @Column(name = "length")
    private Long length;
    
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive = true;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Warehouse warehouse = (Warehouse) o;
        return getId() != null && Objects.equals(getId(), warehouse.getId());
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}