package DKSPACE.PhamarERP.auth.model;

import DKSPACE.PhamarERP.auth.model.composite_id.RolesPermissionId;
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
@Table(name = "roles_permissions", indexes = {
        @Index(name = "roles_permissions_privilege_id_idx", columnList = "privilege_id"),
        @Index(name = "roles_permissions_role_id_idx", columnList = "role_id")
})
public class RolesPermission {
    @EmbeddedId
    private RolesPermissionId id;

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
    private Permission permission;
}