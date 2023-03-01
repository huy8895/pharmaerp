package DKSPACE.PhamarERP.master_data.dto.user;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
public class UserUpdateDTO {
    @Size(max = 10)
    private String testSize;
}
