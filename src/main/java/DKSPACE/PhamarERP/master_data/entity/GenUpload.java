package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.i18n.constants.ValidateCode;
import DKSPACE.PhamarERP.i18n.validation.NotNull;
import jakarta.persistence.*;
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
    @NotNull(message = ValidateCode.NOT_NULL)
    @Column(name = "original_name", nullable = false)
    private String originalName;

    @Size(max = 45)
    @NotNull(message = ValidateCode.NOT_NULL)
    @Column(name = "file_name", nullable = false, length = 45)
    private String fileName;

    @Size(max = 10)
    @NotNull(message = ValidateCode.NOT_NULL)
    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @Size(max = 255)
    @NotNull(message = ValidateCode.NOT_NULL)
    @Column(name = "content_type", nullable = false)
    private String contentType;

    @NotNull(message = ValidateCode.NOT_NULL)
    @Column(name = "data", nullable = false)
    @Lob
    private byte[] data;

    @NotNull(message = ValidateCode.NOT_NULL)
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