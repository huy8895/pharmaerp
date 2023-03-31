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
@Table(name = "documents", indexes = {
		@Index(name = "documents_name_vi_unique", columnList = "name_vi", unique = true)
})
@JsonIgnoreProperties(value = "isActive", allowGetters = true)
public class Document extends BaseCRUDEntity implements Toggleable {
	
	@NotNull
	@Column(name = "document_group_id", nullable = false)
	private Long documentGroupId;
	
	@Size(max = 255)
	@NotNull
	@Column(name = "name_vi", nullable = false)
	private String nameVi;
	
	@Size(max = 255)
	@Column(name = "name_en")
	private String nameEn;
	
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private Boolean isActive = true;
}