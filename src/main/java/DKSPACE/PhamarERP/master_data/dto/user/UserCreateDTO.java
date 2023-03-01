package DKSPACE.PhamarERP.master_data.dto.user;

import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.i18n.validation.UserTypeSubset;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
public class UserCreateDTO {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @Size(max = 100)
    @NotNull
    private String email;

    @Size(max = 100)
    @NotNull
    private String password;

    @Size(max = 50)
    @NotNull
    private String username;

    @Size(max = 45)
    private String phoneNumber;

    @Size(max = 45)
    @NotNull
    @UserTypeSubset(noneOf = UserType.SUPER_ADMIN)
    private String type;

    @Size(max = 45)
    @NotNull
    private String firstName;

    @Size(max = 45)
    @NotNull
    private String lastName;

    private Boolean isActive;

    @Size(max = 20)
    @NotNull
    private String staffCode;
}
