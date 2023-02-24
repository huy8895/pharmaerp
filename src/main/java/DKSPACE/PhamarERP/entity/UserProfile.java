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
import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@Entity
@Table(name = "user_profiles", indexes = {
        @Index(name = "user_id_UNIQUE", columnList = "user_id", unique = true)
})
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "dob")
    private LocalDate dob;

    @Size(max = 45)
    @Column(name = "nationality", length = 45)
    private String nationality;

    @Size(max = 255)
    @Column(name = "permanent_address")
    private String permanentAddress;

    @Size(max = 45)
    @Column(name = "id_card_number", length = 45)
    private String idCardNumber;

    @Column(name = "id_card_issuance_date")
    private LocalDate idCardIssuanceDate;

    @Size(max = 255)
    @Column(name = "id_card_issuance_where")
    private String idCardIssuanceWhere;

    @Size(max = 45)
    @Column(name = "tax_code", length = 45)
    private String taxCode;

    @Lob
    @Column(name = "note")
    private String note;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;


}