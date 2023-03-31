package DKSPACE.PhamarERP.auth.model;

import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.basecrud.Toggleable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
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
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(name = "uq_users_email", columnNames = "email")})
@JsonIgnoreProperties(value = "isActive", allowGetters = true)
public class User extends BaseCRUDEntity implements Toggleable {
    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    
    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false, length = 45)
    @ToString.Exclude
    @JsonIgnore
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
    
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive = true;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    @JsonIgnoreProperties(value = { "permissions" }, allowSetters = true)
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
