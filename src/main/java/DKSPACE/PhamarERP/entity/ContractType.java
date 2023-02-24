package DKSPACE.PhamarERP.entity;

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
@Table(name = "contract_types", indexes = {
        @Index(name = "name_UNIQUE", columnList = "name", unique = true)
})
public class ContractType extends BaseCRUDEntity {
    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Column(name = "is_determine_deadline", nullable = false)
    private Boolean isDetermineDeadline = false;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @Lob
    @Column(name = "`describe`")
    private String describe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ContractType that = (ContractType) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}