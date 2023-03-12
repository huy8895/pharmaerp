package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_profiles")
public class UserProfile extends BaseCRUDEntity {

	@NotNull
	@OneToOne(optional = false)
	@JoinColumn(name = "user_id", unique = true, nullable = false)
	private User user;
	
	@Column(name = "gender")
	private Short gender;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Size(max = 45)
	@Column(name = "nationality", length = 45)
	private String nationality;
	
	@Size(max = 255)
	@Column(name = "permanent_address")
	private String permanentAddress;
	
	@Size(max = 45)
	@Column(name = "id_card_number", length = 45)
	private String idCardNumber;
	
	@Column(name = "id_card_issuance_date")
	private LocalDate idCardIssuanceDate;
	
	@Size(max = 255)
	@Column(name = "id_card_issuance_where")
	private String idCardIssuanceWhere;
	
	@Size(max = 45)
	@Column(name = "tax_code", length = 45)
	private String taxCode;
	
	@Column(name = "note", length = Integer.MAX_VALUE)
	private String note;
	
	@Size(max = 255)
	@Column(name = "bank_name")
	private String bankName;
	
	@Size(max = 20)
	@Column(name = "bank_account_number", length = 20)
	private String bankAccountNumber;
	
	@Size(max = 100)
	@Column(name = "bank_account_name", length = 100)
	private String bankAccountName;
	
	@Size(max = 255)
	@Column(name = "bank_branch")
	private String bankBranch;
}