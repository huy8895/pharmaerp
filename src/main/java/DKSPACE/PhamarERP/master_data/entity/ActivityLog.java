package DKSPACE.PhamarERP.master_data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activity_logs", indexes = {
		@Index(name = "activity_logs_user_id_idx", columnList = "user_id")
})
public class ActivityLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "user_id")
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
	
	@Column(name = "created_at")
	private Instant createdAt;
	
	@Column(name = "updated_at")
	private Instant updatedAt;
	
	@Column(name = "deleted_at")
	private Instant deletedAt;
}