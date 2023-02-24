package DKSPACE.PhamarERP.auth.model;

import DKSPACE.PhamarERP.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(name = "uq_users_email", columnNames = "email")})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 45)
    @Column(name = "phone_number", length = 45)
    private String phoneNumber;

    @Size(max = 45)
    @NotNull
    @Column(name = "type", nullable = false, length = 45)
    private String type;

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

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @OneToMany(mappedBy = "creator")
    @ToString.Exclude
    private Set<Contract> contracts = new LinkedHashSet<>();

    @OneToOne(mappedBy = "user")
    private Contract contract;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<UserCours> userCourses = new LinkedHashSet<>();

    @OneToOne(mappedBy = "user")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<UserCertificate> userCertificates = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<UserActivity> userActivities = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private Set<DKSPACE.PhamarERP.entity.Role> roles = new LinkedHashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
