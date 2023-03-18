package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.auth.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "setting_themes", indexes = {
		@Index(name = "setting_themes_user_id_idx", columnList = "user_id")
})
public class SettingTheme extends BaseCRUDEntity {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Size(max = 20)
	@NotNull
	@Column(name = "layout", nullable = false, length = 20)
	private String layout;
	
	@Size(max = 20)
	@NotNull
	@Column(name = "color_scheme", nullable = false, length = 20)
	private String colorScheme;
	
	@Size(max = 20)
	@NotNull
	@Column(name = "topbar_color", nullable = false, length = 20)
	private String topbarColor;
	
	@Size(max = 20)
	@NotNull
	@Column(name = "sidebar_color", nullable = false, length = 20)
	private String sidebarColor;
	
	@Size(max = 20)
	@NotNull
	@Column(name = "sidebar_img", nullable = false, length = 20)
	private String sidebarImg;
	
	@Size(max = 20)
	@NotNull
	@Column(name = "preloader", nullable = false, length = 20)
	private String preloader;
	
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
	
	public String getLayout() {
		return layout;
	}
	
	public void setLayout(String layout) {
		this.layout = layout;
	}
	
	public String getColorScheme() {
		return colorScheme;
	}
	
	public void setColorScheme(String colorScheme) {
		this.colorScheme = colorScheme;
	}
	
	public String getTopbarColor() {
		return topbarColor;
	}
	
	public void setTopbarColor(String topbarColor) {
		this.topbarColor = topbarColor;
	}
	
	public String getSidebarColor() {
		return sidebarColor;
	}
	
	public void setSidebarColor(String sidebarColor) {
		this.sidebarColor = sidebarColor;
	}
	
	public String getSidebarImg() {
		return sidebarImg;
	}
	
	public void setSidebarImg(String sidebarImg) {
		this.sidebarImg = sidebarImg;
	}
	
	public String getPreloader() {
		return preloader;
	}
	
	public void setPreloader(String preloader) {
		this.preloader = preloader;
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