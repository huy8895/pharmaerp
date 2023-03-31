package DKSPACE.PhamarERP.supplier.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
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
@Table(name = "supplier_contacts")
public class SupplierContact extends BaseCRUDEntity {
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "supplier_id", nullable = false)
	private Supplier supplier;
	
	@Size(max = 100)
	@NotNull
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	@Size(max = 20)
	@Column(name = "tel", length = 20)
	private String tel;
	
	@Size(max = 50)
	@Column(name = "first_name", length = 50)
	private String firstName;
	
	@Size(max = 50)
	@Column(name = "last_name", length = 50)
	private String lastName;
	
	@Size(max = 50)
	@Column(name = "english_name", length = 50)
	private String englishName;
	
	@Size(max = 100)
	@Column(name = "designation", length = 100)
	private String designation;
	
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private Boolean isActive = true;
}