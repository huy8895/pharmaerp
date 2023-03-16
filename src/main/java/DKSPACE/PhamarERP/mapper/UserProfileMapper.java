package DKSPACE.PhamarERP.mapper;

import DKSPACE.PhamarERP.master_data.dto.user_profile.UserProfileResDto;
import DKSPACE.PhamarERP.master_data.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileMapper {
	
    public UserProfileResDto toDTO(UserProfile entity){
	    return UserProfileResDto.builder()
	                            .userId(entity.getUserId())
		                        .createdAt(entity.getCreatedAt())
		                        .updatedAt(entity.getUpdatedAt())
		                        .deletedAt(entity.getDeletedAt())
		                        .gender(entity.getGender())
		                        .dob(entity.getDob())
		                        .nationality(entity.getNationality())
		                        .permanentAddress(entity.getPermanentAddress())
		                        .idCardNumber(entity.getIdCardNumber())
		                        .idCardIssuanceDate(entity.getIdCardIssuanceDate())
		                        .idCardIssuanceWhere(entity.getIdCardIssuanceWhere())
		                        .taxCode(entity.getTaxCode())
		                        .note(entity.getNote())
		                        .bankName(entity.getBankName())
		                        .bankAccountNumber(entity.getBankAccountNumber())
		                        .bankAccountName(entity.getBankAccountName())
		                        .bankBranch(entity.getBankBranch())
		                        .build();
    }

//	public User toEntity(UserAddRolesDTO dto) {
//
//	}
//
//	public User toEntity(UserUpdateDTO dto) {
//
//	}
}
