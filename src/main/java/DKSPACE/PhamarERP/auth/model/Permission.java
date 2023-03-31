package DKSPACE.PhamarERP.auth.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.basecrud.Toggleable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Entity
@Table(name = "permissions")
@JsonIgnoreProperties(value = "isActive", allowGetters = true)
public class Permission extends BaseCRUDEntity implements Toggleable {
    
    @NotNull
    @Column(name = "\"group\"", nullable = false, length = 100)
    private String group;
    
    @NotNull
    @Column(name = "key", nullable = false)
    private String key;
    
    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

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