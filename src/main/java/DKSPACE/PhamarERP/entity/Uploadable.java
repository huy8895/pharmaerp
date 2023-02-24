package DKSPACE.PhamarERP.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@Entity
@Table(name = "uploadables")
public class Uploadable {
    @EmbeddedId
    private UploadableId id;

    @MapsId("genUploadId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gen_upload_id", nullable = false)
    @ToString.Exclude
    private GenUpload genUpload;

    @Size(max = 45)
    @Column(name = "object_type", length = 45)
    private String objectType;

    @Size(max = 45)
    @Column(name = "object_filed", length = 45)
    private String objectFiled;

    @Lob
    @Column(name = "`describe`")
    private String describe;


}