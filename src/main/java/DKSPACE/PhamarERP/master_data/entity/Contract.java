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

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contracts", indexes = {
		@Index(name = "contracts_user_id_unique", columnList = "user_id", unique = true),
		@Index(name = "contracts_gen_job_title_id_idx", columnList = "gen_job_title_id"),
		@Index(name = "contracts_contract_type_id_idx", columnList = "contract_type_id"),
		@Index(name = "contracts_creator_id_idx", columnList = "creator_id"),
		@Index(name = "contracts_gen_work_location_id_idx", columnList = "gen_work_location_id"),
		@Index(name = "contracts_gen_officer_level_id_idx", columnList = "gen_officer_level_id")
})
public class Contract extends BaseCRUDEntity{
	
	@NotNull
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "creator_id", nullable = false)
	private User creator;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "contract_type_id", nullable = false)
	private ContractType contractType;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gen_work_location_id", nullable = false)
	private GenWorkLocation genWorkLocation;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gen_officer_level_id", nullable = false)
	private GenOfficerLevel genOfficerLevel;
	
	@NotNull
	@Column(name = "gen_department_id", nullable = false)
	private Long genDepartmentId;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gen_job_title_id", nullable = false)
	private GenJobTitle genJobTitle;
	
	@Size(max = 45)
	@NotNull
	@Column(name = "contract_code", nullable = false, length = 45)
	private String contractCode;
	
	@Column(name = "duration")
	private Long duration;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Size(max = 45)
	@NotNull
	@Column(name = "status", nullable = false, length = 45)
	private String status;
	
	@Column(name = "note", length = Integer.MAX_VALUE)
	private String note;
	
}