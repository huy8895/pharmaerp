package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activity_logs", indexes = {
		@Index(name = "activity_logs_user_id_idx", columnList = "user_id")
})
public class ActivityLog extends BaseCRUDEntity {
	
	@NotNull
	@Column(name = "user_id", nullable = false )
	private Long userId;
	
	@Size(max = 20)
	@NotNull
	@Column(name = "ip", nullable = false, length = 20)
	private String ip;
	
	@Column(name = "user_agent", length = Integer.MAX_VALUE)
	private String userAgent;
	
	@Column(name = "request", length = Integer.MAX_VALUE)
	private String request;
	
	@Column(name = "response", length = Integer.MAX_VALUE)
	private String response;
}
	
	