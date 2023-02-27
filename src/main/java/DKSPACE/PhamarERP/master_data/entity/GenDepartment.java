package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "gen_departments")
public class GenDepartment extends BaseCRUDEntity {

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Column(name = "describe", length = Integer.MAX_VALUE)
    private String describe;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Short isActive;

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
        GenDepartment that = (GenDepartment) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}