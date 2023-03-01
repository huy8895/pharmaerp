package DKSPACE.PhamarERP.mapper;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.master_data.dto.user.UserResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper {
    public UserResDTO toDTO(User user){
        UserResDTO userResDTO = UserResDTO.builder()
										  .id(user.getId())
										  .email(user.getEmail())
										  .username(user.getUsername())
										  .phoneNumber(user.getPhoneNumber())
										  .type(user.getType().name())
										  .firstName(user.getFirstName())
										  .lastName(user.getLastName())
										  .staffCode(user.getStaffCode())
										  .build();
        return userResDTO;
    }

}
