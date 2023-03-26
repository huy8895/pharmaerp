package DKSPACE.PhamarERP.basecrud.query;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity_;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.RangeFilter;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public interface FilterService<ENTITY extends BaseCRUDEntity, C extends BaseCrudCriteria<ENTITY>> {
	
	@Transactional(readOnly = true)
	default Page<ENTITY> findByCriteria(C criteria, Pageable page, BiFunction<Specification<ENTITY>, Pageable, Page<ENTITY>> findAll) {
		final Specification<ENTITY> specification = this.createSpecification(criteria);
		final var entitySpecification =
				SpecificationBuilder.from(specification)
				                    .and(criteria.getId(), BaseCRUDEntity_.id, this::buildRangeSpecification)
				                    .and(criteria.getCreatedAt(), BaseCRUDEntity_.createdAt, this::buildRangeSpecification)
				                    .and(criteria.getUpdatedAt(), BaseCRUDEntity_.updatedAt, this::buildRangeSpecification)
				                    .and(criteria.getDeletedAt(), BaseCRUDEntity_.deletedAt, this::buildRangeSpecification)
				                    .and(criteria, this::buildSearchSpecification)
				                    .build();
		
		return findAll.apply(entitySpecification, page);
	}
	
	default Specification<ENTITY> buildSearchSpecification(C criteria){
		return Specification.where(null);
	}
	
	default List<SingularAttribute<ENTITY, ?>> searchInColumns(){
		return Collections.emptyList();
	}
	
	Specification<ENTITY> createSpecification(C criteria);
	<X> Specification<ENTITY> buildSpecification(Filter<X> filter, SingularAttribute<? super ENTITY, X> field);
	<X extends Comparable<? super X>> Specification<ENTITY> buildRangeSpecification(RangeFilter<X> filter,
	                                                                                        SingularAttribute<? super ENTITY, X> field);

}
