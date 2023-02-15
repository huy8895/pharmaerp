package DKSPACE.PhamarERP.auth.dto.register;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReqDto {
    private String firstname;
    private String Lastname;
    private String email;
    private String password;
}
