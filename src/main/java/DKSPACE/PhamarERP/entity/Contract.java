package DKSPACE.PhamarERP.entity;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@Entity
@Table(name = "contracts", indexes = {
        @Index(name = "rhrtfgfg_idx", columnList = "gen_officer_level_id"),
        @Index(name = "yhvbhgj_idx", columnList = "gen_work_location_id"),
        @Index(name = "dfhfuy_idx", columnList = "gen_job_title_id"),
        @Index(name = "user_id_UNIQUE", columnList = "user_id", unique = true),
        @Index(name = "fsgfh_idx", columnList = "creator_id")
})
public class Contract extends BaseCRUDEntity {
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "creator_id", nullable = false)
    @ToString.Exclude
    private User creator;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contract_type_id", nullable = false)
    @ToString.Exclude
    private ContractType contractType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "gen_work_location_id", nullable = false)
    @ToString.Exclude
    private GenWorkLocation genWorkLocation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "gen_officer_level_id", nullable = false)
    @ToString.Exclude
    private GenOfficerLevel genOfficerLevel;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "gen_job_title_id", nullable = false)
    @ToString.Exclude
    private GenJobTitle genJobTitle;

    @Size(max = 45)
    @NotNull
    @Column(name = "contract_code", nullable = false, length = 45)
    private String contractCode;

    @Column(name = "duration", columnDefinition = "INT UNSIGNED")
    private Long duration;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Size(max = 45)
    @NotNull
    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @Lob
    @Column(name = "note")
    private String note;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Contract contract = (Contract) o;
        return getId() != null && Objects.equals(getId(), contract.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}