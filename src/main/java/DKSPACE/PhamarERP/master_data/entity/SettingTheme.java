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

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "setting_themes", indexes = {
		@Index(name = "setting_themes_user_id_idx", columnList = "user_id")
})
public class SettingTheme extends BaseCRUDEntity {
	
	@NotNull
	@Column(name = "user_id", nullable = false )
	private Long userId;
	
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
	
	
}