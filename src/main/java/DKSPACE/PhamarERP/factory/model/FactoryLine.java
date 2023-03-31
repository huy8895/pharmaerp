package DKSPACE.PhamarERP.factory.model;


import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.basecrud.Toggleable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "factory_lines")
@JsonIgnoreProperties(value = "isActive", allowGetters = true)
public class FactoryLine extends BaseCRUDEntity implements Toggleable {
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factory_id")
    private Factory factory;
    
    @NotBlank
    @Size(max = 20)
    @Column(name = "name_vi")
    private String nameVi;

    @Size(max = 255)
    @Column(name = "name_en")
    private String nameEn;

    @NotBlank
    @Size(max = 45)
    @Column(name = "factory_line_code", unique = true)
    private String factoryLineCode;

    @Size(max = 1000)
    @Column(name = "`describe`")
    private String describe;
    
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive = true;
}
