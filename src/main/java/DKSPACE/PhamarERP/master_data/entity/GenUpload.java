package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@Entity
@Table(name = "gen_uploads", indexes = {
        @Index(name = "original_name_UNIQUE", columnList = "original_name", unique = true)
})
public class GenUpload extends BaseCRUDEntity {

    @Size(max = 255)
    @NotNull
    @Column(name = "original_name", nullable = false)
    private String originalName;

    @Size(max = 45)
    @NotNull
    @Column(name = "file_name", nullable = false, length = 45)
    private String fileName;

    @Size(max = 10)
    @NotNull
    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @Size(max = 255)
    @NotNull
    @Column(name = "content_type", nullable = false)
    private String contentType;

    @NotNull
    @Column(name = "data", nullable = false)
    @Lob
    private byte[] data;

    @NotNull
    @Column(name = "size", nullable = false)
    private Float size;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GenUpload genUpload = (GenUpload) o;
        return getId() != null && Objects.equals(getId(), genUpload.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}