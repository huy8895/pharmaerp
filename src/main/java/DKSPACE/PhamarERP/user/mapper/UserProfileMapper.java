package DKSPACE.PhamarERP.user.mapper;

import DKSPACE.PhamarERP.user.dto.user_profile.UserProfileReqDto;
import DKSPACE.PhamarERP.user.dto.user_profile.UserProfileResDto;
import DKSPACE.PhamarERP.user.model.UserProfile;
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

	public UserProfile toEntity(UserProfileReqDto dto) {
		return UserProfile.builder()
			              .userId(dto.getUserId())
			              .gender(dto.getGender())
			              .dob(dto.getDob())
			              .nationality(dto.getNationality())
			              .permanentAddress(dto.getPermanentAddress())
			              .idCardNumber(dto.getIdCardNumber())
			              .idCardIssuanceDate(dto.getIdCardIssuanceDate())
			              .idCardIssuanceWhere(dto.getIdCardIssuanceWhere())
			              .taxCode(dto.getTaxCode())
			              .note(dto.getNote())
			              .bankName(dto.getBankName())
			              .bankAccountNumber(dto.getBankAccountNumber())
			              .bankAccountName(dto.getBankAccountName())
			              .bankBranch(dto.getBankBranch())
			              .build();
	}
}
