package DKSPACE.PhamarERP.auth.dto.jwt;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
public class JwtTokenDTO {
    private String token;
    private List<String> roles;
    private List<String> permissions;
    private int expirationIn;
}
