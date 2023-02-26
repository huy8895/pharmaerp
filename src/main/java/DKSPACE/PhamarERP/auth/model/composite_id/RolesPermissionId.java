package DKSPACE.PhamarERP.auth.model.composite_id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RolesPermissionId implements Serializable {
    private static final long serialVersionUID = -3078829726176762652L;
    @NotNull
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @NotNull
    @Column(name = "privilege_id", nullable = false)
    private Long privilegeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RolesPermissionId entity = (RolesPermissionId) o;
        return Objects.equals(this.privilegeId, entity.privilegeId) &&
                Objects.equals(this.roleId, entity.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(privilegeId, roleId);
    }

}