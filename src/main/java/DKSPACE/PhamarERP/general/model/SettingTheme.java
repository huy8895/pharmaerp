package DKSPACE.PhamarERP.general.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * đại diện cho các thiết lập giao diện của người dùng trên hệ thống.
 */
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
	
	/**
	 * Mã người dùng.
	 */
	@NotNull
	@Column(name = "user_id", nullable = false )
	private Long userId;
	
	/**
	 * Kiểu bố cục giao diện. Có thể chọn một trong ba giá trị: vertical, horizontal hoặc twocolumn. Giá trị mặc định là vertical.
	 */
	@Size(max = 20)
	@NotNull
	@Column(name = "layout", nullable = false, length = 20, columnDefinition="varchar(20) default 'vertical'")
	private String layout;
	
	/**
	 * Bảng màu giao diện. Có thể chọn một trong hai giá trị: light hoặc dark. Giá trị mặc định là light.
	 */
	@Size(max = 20)
	@NotNull
	@Column(name = "color_scheme", nullable = false, length = 20, columnDefinition="varchar(20) default 'light'")
	private String colorScheme;
	
	/**
	 * Màu thanh trên cùng (topbar). Có thể chọn một trong hai giá trị: light hoặc dark. Giá trị mặc định là light.
	 */
	@Size(max = 20)
	@NotNull
	@Column(name = "topbar_color", nullable = false, length = 20, columnDefinition="varchar(20) default 'light'")
	private String topbarColor;
	
	/**
	 * Màu thanh bên (sidebar). Có thể chọn một trong ba giá trị: light, dark hoặc gradient. Giá trị mặc định là light.
	 */
	@Size(max = 20)
	@NotNull
	@Column(name = "sidebar_color", nullable = false, length = 20, columnDefinition="varchar(20) default 'light'")
	private String sidebarColor;
	
	/**
	 * Hình nền cho thanh bên (sidebar). Có thể chọn nhiều giá trị có dạng img-1, img-2,...img-n hoặc none nếu không muốn hình nền. Giá trị mặc định là none.
	 */
	@Size(max = 20)
	@NotNull
	@Column(name = "sidebar_img", nullable = false, length = 20,columnDefinition="varchar(20) default 'none'")
	private String sidebarImg;
	
	/**
	 * Kiểu hiển thị trạng thái tải (preloader). Có thể chọn một trong hai giá trị: enable hoặc disable. Giá trị mặc định là enable.
	 */
	@Size(max = 20)
	@NotNull
	@Column(name = "preloader", nullable = false,length= 20,columnDefinition="varchar(20) default 'enable'")
	private String preloader;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		SettingTheme that = (SettingTheme) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}