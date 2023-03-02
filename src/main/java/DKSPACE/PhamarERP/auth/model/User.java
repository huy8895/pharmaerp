package DKSPACE.PhamarERP.auth.model;

import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Accessors(chain = true)
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(name = "uq_users_email", columnNames = "email")})
public class User  extends BaseCRUDEntity{
    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false, length = 45)
    @ToString.Exclude
    private String password;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 45)
    @Column(name = "phone_number", length = 45)
    private String phoneNumber;

    /**
     * Loại người dùng, cái này cần thêm để phân loại theo phòng ban.
     * Ví dụ: QA, QC, R&D, BOD, IPC, Sale, HR, Accountant, IT ....
     */
    @NotNull
    @Column(name = "type", nullable = false, length = 45)
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Size(max = 45)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Size(max = 45)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private Set<Role> roles = new LinkedHashSet<>();

    @Size(max = 20)
    @NotNull
    @Column(name = "staff_code", nullable = false, length = 20)
    private String staffCode;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
