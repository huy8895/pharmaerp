package DKSPACE.PhamarERP.general.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UploadableId implements Serializable {
	private static final long serialVersionUID = -2903488751122295749L;
	@NotNull
	private Long genUploadId;
	
	@NotNull
	private Long objectId;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		UploadableId entity = (UploadableId) o;
		return Objects.equals(this.genUploadId, entity.genUploadId) &&
				Objects.equals(this.objectId, entity.objectId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(genUploadId, objectId);
	}
	
}