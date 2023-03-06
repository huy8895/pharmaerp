package DKSPACE.PhamarERP.master_data.dto.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
public class UserCreateListDTO {
	@Valid
	@NotNull
	private List<UserCreateDTO> listUser;
}
