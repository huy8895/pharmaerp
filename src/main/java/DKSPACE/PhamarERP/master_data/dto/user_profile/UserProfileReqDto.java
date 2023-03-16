package DKSPACE.PhamarERP.master_data.dto.user_profile;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

/**
 * A DTO for the {@link DKSPACE.PhamarERP.master_data.entity.UserProfile} entity
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