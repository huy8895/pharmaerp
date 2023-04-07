package DKSPACE.PhamarERP.factory.model;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.basecrud.Toggleable;
import DKSPACE.PhamarERP.i18n.validation.Uniques;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "factories")
@JsonIgnoreProperties(value = "isActive", allowGetters = true)
@Uniques(values = Factory_.FACTORY_CODE, domainClass = Factory.class)
public class Factory extends BaseCRUDEntity implements Toggleable {
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
    
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive = true;
}
