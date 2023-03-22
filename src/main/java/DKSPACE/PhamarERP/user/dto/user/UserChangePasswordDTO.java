package DKSPACE.PhamarERP.user.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
public class UserChangePasswordDTO {
    @NotNull
    private Long id;
    
    @NotNull
    private String newPassword;
    
    @NotNull
    private String confirmPassword;
}
