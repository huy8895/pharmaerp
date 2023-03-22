package DKSPACE.PhamarERP.user.dto.user_profile;

import DKSPACE.PhamarERP.user.model.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link UserProfile} entity
 */
@Builder
@Getter
@AllArgsConstructor
public class UserProfileResDto implements Serializable {
	private final Long userId;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;
	private final LocalDateTime deletedAt;
	private final Short gender;
	private final LocalDate dob;
	private final String nationality;
	private final String permanentAddress;
	private final String idCardNumber;
	private final LocalDate idCardIssuanceDate;
	private final String idCardIssuanceWhere;
	private final String taxCode;
	private final String note;
	private final String bankName;
	private final String bankAccountNumber;
	private final String bankAccountName;
	private final String bankBranch;
}