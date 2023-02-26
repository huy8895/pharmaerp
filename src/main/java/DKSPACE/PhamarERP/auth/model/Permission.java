package DKSPACE.PhamarERP.auth.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;

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
    private String group;

    @Size(max = 255)
    @NotNull
    @Column(name = "key", nullable = false)
    private String key;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}