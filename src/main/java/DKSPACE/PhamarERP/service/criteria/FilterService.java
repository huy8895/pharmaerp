package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.helper.query.Criteria;
import org.springframework.data.domain.Pageable;

public interface FilterService<C extends Criteria<? extends BaseCRUDEntity>> {
	Object findByCriteria(C criteria, Pageable pageable);
}
