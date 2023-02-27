package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.i18n.constants.ValidateCode;
import DKSPACE.PhamarERP.i18n.validation.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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
@Table(name = "gen_officer_levels")
public class GenOfficerLevel extends BaseCRUDEntity {

    @Lob
    @Column(name = "`describe`")
    private String describe;

    @NotNull(message = ValidateCode.NOT_NULL)
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @Size(max = 100)
    @NotNull
    @Column(name = "name_vi", nullable = false, length = 100)
    private String nameVi;

    @Size(max = 100)
    @NotNull
    @Column(name = "name_en", nullable = false, length = 100)
    private String nameEn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GenOfficerLevel that = (GenOfficerLevel) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}