package DKSPACE.PhamarERP.auth.dto.permission;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionsDTO {
    private Long id;
    private String group;
    private String groupName;
    private String key;
    private String keyName;

}
