package DKSPACE.PhamarERP.user.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_profiles")

public class UserProfile extends BaseCRUDEntity {
	
	/**
	 * Mã định danh của người dùng.
	 */
	@NotNull
	@Column(name = "user_id", unique = true)
	private Long userId;
	
	/**
	 * Giới tính của người dùng. Có kiểu Short để biểu diễn 0 là nam, 1 là nữ và 2 là khác.
	 */
	@Column(name = "gender")
	private Short gender;
	
	/**
	 * Ngày sinh của người dùng.
	 */
	@Column(name = "dob")
	private LocalDate dob;
	
	/**
	 * Quốc tịch của người dùng.
	 */
	@Size(max = 45)
	@Column(name = "nationality", length = 45)
	private String nationality;
	
	/**
	 * Địa chỉ thường trú của người dùng.
	 */
	@Size(max = 255)
	@Column(name = "permanent_address")
	private String permanentAddress;
	
	/**
	 * Số chứng minh nhân dân của người dùng.
	 */
	@Size(max = 45)
	@Column(name = "id_card_number", length = 45)
	private String idCardNumber;
	
	/**
	 * Ngày cấp chứng minh nhân dân của người dùng.
	 */
	@Column(name = "id_card_issuance_date")
	private LocalDate idCardIssuanceDate;
	
	/**
	 * Nơi cấp chứng minh nhân dân của người dùng.
	 */
	@Size(max = 255)
	@Column(name = "id_card_issuance_where")
	private String idCardIssuanceWhere;
	
	/**
	 * Mã số thuế cá nhân của người dùng.
	 */
	@Size(max = 45)
	@Column(name = "tax_code", length = 45)
	private String taxCode;
	
	/**
	 * Ghi chú về người dùng. Có thể bao gồm bất kỳ thông tin nào liên quan đến người dùng.
	 */
	@Column(name = "note", length = Integer.MAX_VALUE)
	private String note;
	
	/**
	 * Tên ngân hàng mà người dùng mở tài khoản.
	 */
	@Size(max = 255)
	@Column(name = "bank_name")
	private String bankName;
	
	/**
	 * Số tài khoản ngân hàng của người dùng.
	 */
	@Size(max = 20)
	@Column(name = "bank_account_number", length = 20)
	private String bankAccountNumber;
	
	/**
	 * Tên chủ sở hữu tài khoản ngân hàng của người dùng. Thường trùng với họ và tên của người dùng trong hệ thống.
	 */
	@Size(max = 100)
	@Column(name = "bank_account_name", length = 100)
	private String bankAccountName;
	
	/**
	 * Chi nhánh mà người dùng mở tài khoản. Thường bao gồm tên thành phố hoặc quận huyện nơi có chi nhánh đó.
	 */
	@Size(max = 255)
	@Column(name = "bank_branch")
	private String bankBranch;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		UserProfile that = (UserProfile) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}