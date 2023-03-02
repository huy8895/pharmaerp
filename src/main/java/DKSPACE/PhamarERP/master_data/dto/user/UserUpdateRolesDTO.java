package DKSPACE.PhamarERP.master_data.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
public class UserUpdateRolesDTO {
    @NotNull
    private Long id;

    @NotNull
    private Set<Long> rolesId;
}
