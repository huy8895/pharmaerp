package DKSPACE.PhamarERP.user.dto.user;

import DKSPACE.PhamarERP.user.dto.user_profile.UserProfileResDto;
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
public class UserResDTO {
    private Long id;
    private String email;
    private String username;
    private String phoneNumber;
    private String type;
    private String firstName;
    private String lastName;
    private String staffCode;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private Boolean isActive;
    private UserProfileResDto userprofile;
    private final Set<RoleDto> roles;
}
