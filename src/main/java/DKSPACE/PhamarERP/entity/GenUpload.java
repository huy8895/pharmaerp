package DKSPACE.PhamarERP.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "gen_uploads", indexes = {
        @Index(name = "original_name_UNIQUE", columnList = "original_name", unique = true)
})
public class GenUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "original_name", nullable = false)
    private String originalName;

    @Size(max = 45)
    @NotNull
    @Column(name = "file_name", nullable = false, length = 45)
    private String fileName;

    @Size(max = 10)
    @NotNull
    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @Size(max = 255)
    @NotNull
    @Column(name = "content_type", nullable = false)
    private String contentType;

    @NotNull
    @Column(name = "data", nullable = false)
    private byte[] data;

    @NotNull
    @Column(name = "size", nullable = false)
    private Float size;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;


}