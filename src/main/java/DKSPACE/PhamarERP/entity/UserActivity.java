package DKSPACE.PhamarERP.entity;

import DKSPACE.PhamarERP.auth.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@Entity
@Table(name = "user_activities", indexes = {
        @Index(name = "fdjhhkuyk_idx", columnList = "user_id")
})
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;

    @Size(max = 255)
    @NotNull
    @Column(name = "organization", nullable = false)
    private String organization;

    @Size(max = 255)
    @Column(name = "participating_position")
    private String participatingPosition;

    @Column(name = "is_current_active")
    private Boolean isCurrentActive;

    @Size(max = 45)
    @Column(name = "start_date", length = 45)
    private String startDate;

    @Size(max = 45)
    @Column(name = "end_date", length = 45)
    private String endDate;

    @Lob
    @Column(name = "`describe`")
    private String describe;

    @Size(max = 255)
    @Column(name = "link")
    private String link;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;


}