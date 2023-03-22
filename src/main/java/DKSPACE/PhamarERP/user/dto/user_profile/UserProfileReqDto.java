package DKSPACE.PhamarERP.user.dto.user_profile;

import DKSPACE.PhamarERP.user.model.UserProfile;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

/**
 * A DTO for the {@link UserProfile} entity
 */
@Getter
@AllArgsConstructor
public class UserProfileReqDto {
	@NotNull
	private final Long userId;
	private final Short gender;
	private final LocalDate dob;
	@Size(max = 45)
	private final String nationality;
	@Size(max = 255)
	private final String permanentAddress;
	@Size(max = 45)
	private final String idCardNumber;
	private final LocalDate idCardIssuanceDate;
	@Size(max = 255)
	private final String idCardIssuanceWhere;
	@Size(max = 45)
	private final String taxCode;
	private final String note;
	@Size(max = 255)
	private final String bankName;
	@Size(max = 20)
	private final String bankAccountNumber;
	@Size(max = 100)
	private final String bankAccountName;
	@Size(max = 255)
	private final String bankBranch;
}