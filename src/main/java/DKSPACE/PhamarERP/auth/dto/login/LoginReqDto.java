package DKSPACE.PhamarERP.auth.dto.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginReqDto {
    private String email;
    private String password;
}
