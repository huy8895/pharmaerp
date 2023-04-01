package DKSPACE.PhamarERP.user.mapper;

import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.mapper.RoleMapper;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.general.model.Uploadable;
import DKSPACE.PhamarERP.user.dto.user.UserAddRolesDTO;
import DKSPACE.PhamarERP.user.dto.user.UserResDTO;
import DKSPACE.PhamarERP.user.dto.user.UserUpdateDTO;
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
	                     .createdAt(String.valueOf(user.getCreatedAt()))
	                     .updatedAt(String.valueOf(user.getUpdatedAt()))
	                     .deletedAt(String.valueOf(user.getDeletedAt()))
	                     .isActive(user.getIsActive())
	                     .roles(roleMapper.toDTO(user.getRoles()))
	                     .avatar(this.getAvatar(user))
	                     .build();
    }
	
	private String getAvatar(User user) {
		if (user == null) return null;
		return user.getUploadables()
		           .stream()
		           .findFirst()
		           .map(this::mapUpload)
		           .orElse(null);
	}
	
	private String mapUpload(Uploadable uploadable) {
		return "/download/" + uploadable.getId().getGenUploadId();
	}
	
	public User toEntity(UserAddRolesDTO dto) {
		return User.builder()
				   .id(dto.getId())
				   .roles(roleMapper.toEntity(dto.getRolesId()))
				   .build();
	}

	public User toEntity(UserUpdateDTO dto) {
		return User.builder()
				   .id(dto.getId())
				   .email(dto.getEmail())
				   .username(dto.getUsername())
				   .phoneNumber(dto.getPhoneNumber())
				   .firstName(dto.getFirstName())
				   .lastName(dto.getLastName())
				   .staffCode(dto.getStaffCode())
				   .type(UserType.valueOf(dto.getType()))
				   .build();
	}
}
