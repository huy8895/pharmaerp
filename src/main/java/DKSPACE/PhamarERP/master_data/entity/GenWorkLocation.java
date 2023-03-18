package DKSPACE.PhamarERP.master_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "gen_work_locations")
public class GenWorkLocation {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Size(max = 100)
	@NotNull
	@Column(name = "name_vi", nullable = false, length = 100)
	private String nameVi;
	
	@Size(max = 100)
	@NotNull
	@Column(name = "name_en", nullable = false, length = 100)
	private String nameEn;
	
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	@NotNull
	@Column(name = "is_active", nullable = false)
	private Boolean isActive = false;
	
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
	
	public String getNameVi() {
		return nameVi;
	}
	
	public void setNameVi(String nameVi) {
		this.nameVi = nameVi;
	}
	
	public String getNameEn() {
		return nameEn;
	}
	
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	
	public String getDescribe() {
		return describe;
	}
	
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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