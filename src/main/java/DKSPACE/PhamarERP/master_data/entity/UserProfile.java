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
@Table(name = "user_profiles", indexes = {
        @Index(name = "user_id_UNIQUE", columnList = "user_id", unique = true)
})
public class UserProfile extends BaseCRUDEntity {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserProfile that = (UserProfile) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}