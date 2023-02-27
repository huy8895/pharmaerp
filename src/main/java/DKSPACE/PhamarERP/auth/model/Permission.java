package DKSPACE.PhamarERP.auth.model;

import DKSPACE.PhamarERP.auth.enums.permission.PermissionGroupEnum;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
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
@Table(name = "permissions")
public class Permission extends BaseCRUDEntity {

    @Size(max = 100)
    @NotNull
    @Column(name = "\"group\"", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private PermissionGroupEnum group;

    @Size(max = 255)
    @NotNull
    @Column(name = "key", nullable = false)
    @Enumerated(EnumType.STRING)
    private PermissionKeyEnum key;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Permission that = (Permission) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}