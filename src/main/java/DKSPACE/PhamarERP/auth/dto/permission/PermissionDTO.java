package DKSPACE.PhamarERP.auth.dto.permission;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDTO implements Serializable {
    private Long id;
    private String group;
    private String groupName;
    private String key;
    private String keyName;

}
