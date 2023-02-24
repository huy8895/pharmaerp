package DKSPACE.PhamarERP.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "uploadables")
public class Uploadable {
    @EmbeddedId
    private UploadableId id;

    @MapsId("genUploadId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gen_upload_id", nullable = false)
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

    public UploadableId getId() {
        return id;
    }

    public void setId(UploadableId id) {
        this.id = id;
    }

    public GenUpload getGenUpload() {
        return genUpload;
    }

    public void setGenUpload(GenUpload genUpload) {
        this.genUpload = genUpload;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectFiled() {
        return objectFiled;
    }

    public void setObjectFiled(String objectFiled) {
        this.objectFiled = objectFiled;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}