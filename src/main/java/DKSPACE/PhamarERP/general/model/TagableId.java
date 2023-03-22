package DKSPACE.PhamarERP.general.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class TagableId implements Serializable {
	private static final long serialVersionUID = -3978358372257141811L;
	@NotNull
	@Column(name = "tag_id", nullable = false)
	private Long tagId;
	
	@NotNull
	@Column(name = "object_id", nullable = false)
	private Long objectId;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		TagableId entity = (TagableId) o;
		return Objects.equals(this.tagId, entity.tagId) &&
				Objects.equals(this.objectId, entity.objectId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(tagId, objectId);
	}
	
}