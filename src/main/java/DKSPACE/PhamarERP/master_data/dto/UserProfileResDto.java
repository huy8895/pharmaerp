package DKSPACE.PhamarERP.master_data.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link DKSPACE.PhamarERP.master_data.entity.UserProfile} entity
 */
@Data
public class UserProfileResDto implements Serializable {
	private final Long id;
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