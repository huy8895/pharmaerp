package DKSPACE.PhamarERP.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@Entity
@Table(name = "contract_types", indexes = {
        @Index(name = "name_UNIQUE", columnList = "name", unique = true)
})
public class ContractType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Column(name = "is_determine_deadline", nullable = false)
    private Boolean isDetermineDeadline = false;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @Lob
    @Column(name = "`describe`")
    private String describe;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;


}