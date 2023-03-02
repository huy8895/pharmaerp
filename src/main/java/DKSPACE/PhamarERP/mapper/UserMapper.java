package DKSPACE.PhamarERP.mapper;

import DKSPACE.PhamarERP.auth.mapper.RoleMapper;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.master_data.dto.user.UserAddRolesDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper {
	private final RoleMapper roleMapper;
    public UserResDTO toDTO(User user){
		return UserResDTO.builder()
						 .id(user.getId())
						 .email(user.getEmail())
						 .username(user.getUsername())
						 .phoneNumber(user.getPhoneNumber())
						 .type(user.getType().name())
						 .firstName(user.getFirstName())
						 .lastName(user.getLastName())
						 .staffCode(user.getStaffCode())
						 .build();
    }

	public User toEntity(UserAddRolesDTO dto) {
		return User.builder()
				   .id(dto.getId())
				   .roles(roleMapper.toEntity(dto.getRolesId()))
				   .build();
	}

}
