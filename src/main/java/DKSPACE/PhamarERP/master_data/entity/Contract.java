package DKSPACE.PhamarERP.master_data.entity;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.i18n.constants.ValidateCode;
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
    @NotNull(message = ValidateCode.NOT_NULL)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;

    @NotNull(message = ValidateCode.NOT_NULL)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "creator_id", nullable = false)
    @ToString.Exclude
    private User creator;

    @NotNull(message = ValidateCode.NOT_NULL)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contract_type_id", nullable = false)
    @ToString.Exclude
    private ContractType contractType;

    @NotNull(message = ValidateCode.NOT_NULL)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "gen_work_location_id", nullable = false)
    @ToString.Exclude
    private GenWorkLocation genWorkLocation;

    @NotNull(message = ValidateCode.NOT_NULL)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "gen_officer_level_id", nullable = false)
    @ToString.Exclude
    private GenOfficerLevel genOfficerLevel;

    @NotNull(message = ValidateCode.NOT_NULL)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "gen_job_title_id", nullable = false)
    @ToString.Exclude
    private GenJobTitle genJobTitle;

    /**
     * Mã số hợp đồng
     */
    @Size(max = 45)
    @NotNull(message = ValidateCode.NOT_NULL)
    @Column(name = "contract_code", nullable = false, length = 45)
    private String contractCode;

    /**
     * Thời hạn (tháng)
     */
    @Column(name = "duration", columnDefinition = "INT UNSIGNED")
    private Long duration;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    /**
     * 'Draft, To confirm, To review, Approved, Running, Pending, Expired, Liquidated, Rejected
     * Dự thảo, Để xác nhận, Để xem xét, Đã phê duyệt, Đang chạy, Đang chờ xử lý, Đã hết hạn, Đã thanh lý, Bị từ chối'
     */
    @Size(max = 45)
    @NotNull(message = ValidateCode.NOT_NULL)
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