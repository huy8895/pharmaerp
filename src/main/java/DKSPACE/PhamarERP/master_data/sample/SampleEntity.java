package DKSPACE.PhamarERP.master_data.sample;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "sample_entity")
public class SampleEntity extends BaseCRUDEntity {

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;
}
