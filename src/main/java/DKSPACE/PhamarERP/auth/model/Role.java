package DKSPACE.PhamarERP.auth.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@Accessors(chain = true)
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends BaseCRUDEntity {

    @Lob
    @Column(name = "`describe`")
    private String describe;

    /**
     * Default là 1 thì sẽ không được sửa
     */
    @NotNull
    @Column(name = "is_default", nullable = false)
    private Boolean isDefault = false;

    @NotNull
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

    @ManyToMany
    @JoinTable(name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    @ToString.Exclude
    private Set<Permission> permissions = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return getId() != null && Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}