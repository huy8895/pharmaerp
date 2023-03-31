package DKSPACE.PhamarERP.document.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.basecrud.Toggleable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "document_groups", indexes = {
		@Index(name = "document_groups_name_vi_unique", columnList = "name_vi", unique = true)
})
@JsonIgnoreProperties(value = "isActive", allowGetters = true)
public class DocumentGroup extends BaseCRUDEntity implements Toggleable {
	@Column(name = "parent_id")
	private Long parentId;
	
	@Size(max = 100)
	@NotNull
	@Column(name = "name_vi", nullable = false, length = 100)
	private String nameVi;
	
	@Size(max = 100)
	@Column(name = "name_en", length = 100)
	private String nameEn;
	
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private Boolean isActive = true;
}