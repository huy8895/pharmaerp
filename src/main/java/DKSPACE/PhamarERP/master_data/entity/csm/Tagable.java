package DKSPACE.PhamarERP.master_data.entity.csm;

import DKSPACE.PhamarERP.master_data.entity.id.TagableId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "tagables")
public class Tagable {
	@EmbeddedId
	private TagableId id;
	
	@Size(max = 45)
	@Column(name = "object_type", length = 45)
	private String objectType;
	
	@Size(max = 45)
	@Column(name = "object_field", length = 45)
	private String objectField;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Tagable tagable = (Tagable) o;
		return id != null && Objects.equals(id, tagable.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}