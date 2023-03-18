package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.auth.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "contracts", indexes = {
		@Index(name = "contracts_user_id_unique", columnList = "user_id", unique = true),
		@Index(name = "contracts_gen_job_title_id_idx", columnList = "gen_job_title_id"),
		@Index(name = "contracts_contract_type_id_idx", columnList = "contract_type_id"),
		@Index(name = "contracts_creator_id_idx", columnList = "creator_id"),
		@Index(name = "contracts_gen_work_location_id_idx", columnList = "gen_work_location_id"),
		@Index(name = "contracts_gen_officer_level_id_idx", columnList = "gen_officer_level_id")
})
public class Contract {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	
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
	
	@Column(name = "created_at")
	private Instant createdAt;
	
	@Column(name = "updated_at")
	private Instant updatedAt;
	
	@Column(name = "deleted_at")
	private Instant deletedAt;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getCreator() {
		return creator;
	}
	
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public ContractType getContractType() {
		return contractType;
	}
	
	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}
	
	public GenWorkLocation getGenWorkLocation() {
		return genWorkLocation;
	}
	
	public void setGenWorkLocation(GenWorkLocation genWorkLocation) {
		this.genWorkLocation = genWorkLocation;
	}
	
	public GenOfficerLevel getGenOfficerLevel() {
		return genOfficerLevel;
	}
	
	public void setGenOfficerLevel(GenOfficerLevel genOfficerLevel) {
		this.genOfficerLevel = genOfficerLevel;
	}
	
	public Long getGenDepartmentId() {
		return genDepartmentId;
	}
	
	public void setGenDepartmentId(Long genDepartmentId) {
		this.genDepartmentId = genDepartmentId;
	}
	
	public GenJobTitle getGenJobTitle() {
		return genJobTitle;
	}
	
	public void setGenJobTitle(GenJobTitle genJobTitle) {
		this.genJobTitle = genJobTitle;
	}
	
	public String getContractCode() {
		return contractCode;
	}
	
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	
	public Long getDuration() {
		return duration;
	}
	
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public Instant getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	
	public Instant getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Instant getDeletedAt() {
		return deletedAt;
	}
	
	public void setDeletedAt(Instant deletedAt) {
		this.deletedAt = deletedAt;
	}
	
}