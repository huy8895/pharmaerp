package DKSPACE.PhamarERP.factory.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "factories")
public class Factory extends BaseCRUDEntity {
    @NotBlank
    @Size(max = 20)
    @Column(name = "name_vi")
    private String nameVi;

    @Size(max = 255)
    @Column(name = "name_en")
    private String nameEn;

    @NotBlank
    @Size(max = 45)
    @Column(name = "factory_code", unique = true)
    private String factoryCode;

    @Size(max = 1000)
    @Column(name = "`describe`")
    private String describe;

    @Column(name = "is_active")
    @ColumnDefault("true")
    private Boolean isActive;
}
