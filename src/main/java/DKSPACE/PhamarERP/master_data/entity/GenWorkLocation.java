package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.i18n.constants.ValidateCode;
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
@Table(name = "gen_work_locations", indexes = {
        @Index(name = "name_UNIQUE", columnList = "name", unique = true)
})
public class GenWorkLocation extends BaseCRUDEntity {

    @Size(max = 100)
    @NotNull(message = ValidateCode.NOT_NULL)
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Lob
    @Column(name = "`describe`")
    private String describe;

    @NotNull(message = ValidateCode.NOT_NULL)
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GenWorkLocation that = (GenWorkLocation) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}