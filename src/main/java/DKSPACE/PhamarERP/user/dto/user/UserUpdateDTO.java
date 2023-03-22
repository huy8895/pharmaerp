package DKSPACE.PhamarERP.user.dto.user;

import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.i18n.validation.UniqueUser;
import DKSPACE.PhamarERP.i18n.validation.UserTypeSubset;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class UserUpdateDTO {
    @NotNull
    private Long id;

    @Size(max = 100)
    @NotNull
    @Email
    @UniqueUser("email")
    private String email;

    @Size(max = 50)
    @NotNull
    @UniqueUser("username")
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

    @Size(max = 20)
    @NotNull
    private String staffCode;
}
