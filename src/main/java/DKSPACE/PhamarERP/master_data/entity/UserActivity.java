package DKSPACE.PhamarERP.master_data.entity;

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

import java.util.Objects;

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
public class UserActivity extends BaseCRUDEntity {

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

    /**
     * Tôi vẫn đang hoạt động trong tổ chức này, Nếu bằng 0, thì phải nhập start_date và end_date
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserActivity that = (UserActivity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}