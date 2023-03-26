package DKSPACE.PhamarERP.basecrud.query;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import io.github.jhipster.service.filter.LongFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseCrudCriteria<E extends BaseCRUDEntity> implements Criteria<E>{
	private LongFilter id;
	private LocalDateTimeFilter createdAt;
	private LocalDateTimeFilter updatedAt;
	private LocalDateTimeFilter deletedAt;
	private String search;
}
