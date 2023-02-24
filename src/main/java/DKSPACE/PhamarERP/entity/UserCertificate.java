package DKSPACE.PhamarERP.entity;

import DKSPACE.PhamarERP.auth.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "user_certificates", indexes = {
        @Index(name = "sdgdsfgf_idx", columnList = "user_id")
})
public class UserCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
    @Column(name = "organization")
    private String organization;

    @Column(name = "has_no_expiration_date")
    private Boolean hasNoExpirationDate;

    @Size(max = 45)
    @Column(name = "start_date", length = 45)
    private String startDate;

    @Size(max = 45)
    @Column(name = "end_date", length = 45)
    private String endDate;

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