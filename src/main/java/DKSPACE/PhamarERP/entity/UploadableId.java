package DKSPACE.PhamarERP.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UploadableId implements Serializable {
    private static final long serialVersionUID = 8529422246832470926L;
    @NotNull
    @Column(name = "gen_upload_id", nullable = false)
    private Long genUploadId;

    @NotNull
    @Column(name = "object_id", nullable = false)
    private Long objectId;

    public Long getGenUploadId() {
        return genUploadId;
    }

    public void setGenUploadId(Long genUploadId) {
        this.genUploadId = genUploadId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

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