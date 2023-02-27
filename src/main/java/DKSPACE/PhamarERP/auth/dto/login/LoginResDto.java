package DKSPACE.PhamarERP.auth.dto.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResDto {
    private String token;
    private List<String> roles;
    private List<String> permissions;
    private int expirationIn;
}
