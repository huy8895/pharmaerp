package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.helper.query.BaseCrudCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.BiFunction;

public interface FilterService<E extends BaseCRUDEntity, C extends BaseCrudCriteria<E>> {
	
	@Transactional(readOnly = true)
	default Page<E> findByCriteria(C criteria, Pageable page, BiFunction<Specification<E>, Pageable, Page<E>> findAll) {
		final Specification<E> specification = this.createSpecification(criteria);
		return findAll.apply(specification, page);
	}
	
	Specification<E> createSpecification(C criteria);
}
