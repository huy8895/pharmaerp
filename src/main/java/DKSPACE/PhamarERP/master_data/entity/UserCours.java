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
@Table(name = "user_courses", indexes = {
		@Index(name = "user_courses_user_id_idx", columnList = "user_id")
})
public class UserCours extends BaseCRUDEntity {
	
	
	@NotNull
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Size(max = 255)
	@NotNull
	@Column(name = "name", nullable = false)
	private String name;
	
	@Size(max = 255)
	@Column(name = "organization")
	private String organization;
	
	@Size(max = 45)
	@Column(name = "start_date", length = 45)
	private String startDate;
	
	@Size(max = 45)
	@Column(name = "end_date", length = 45)
	private String endDate;
	
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	@Size(max = 255)
	@Column(name = "link")
	private String link;
	
	
}