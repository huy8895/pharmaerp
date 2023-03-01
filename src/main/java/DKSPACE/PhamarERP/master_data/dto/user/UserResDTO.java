package DKSPACE.PhamarERP.master_data.dto.user;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
public class UserResDTO {
    private Long id;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private String type;
    private String firstName;
    private String lastName;
    private String staffCode;
}
