package DKSPACE.PhamarERP.master_data.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class UserUpdateDTO extends UserCreateDTO{
    @NotNull
    private Long id;
}
