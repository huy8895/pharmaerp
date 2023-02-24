package DKSPACE.PhamarERP.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@Entity
@Table(name = "roles_privileges", indexes = {
        @Index(name = "role_fk_idx", columnList = "role_id")
})
public class RolesPrivilege {
    @EmbeddedId
    private RolesPrivilegeId id;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "role_id", nullable = false)
    @ToString.Exclude
    private Role role;

    @MapsId("privilegeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "privilege_id", nullable = false)
    @ToString.Exclude
    private Privilege privilege;


}