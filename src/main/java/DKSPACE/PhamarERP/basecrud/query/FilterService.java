package DKSPACE.PhamarERP.basecrud.query;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity_;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.BiFunction;

public abstract class FilterService<ENTITY extends BaseCRUDEntity, C extends BaseCrudCriteria<ENTITY>> extends QueryService<ENTITY> {
	
	@Transactional(readOnly = true)
	public Page<ENTITY> findByCriteria(C criteria, Pageable page,
	                                   BiFunction<Specification<ENTITY>, Pageable, Page<ENTITY>> findAll) {
		final Specification<ENTITY> specification = this.createSpecification(criteria);
		final var entitySpecification =
				SpecificationBuilder.from(specification)
				                    .and(criteria.getId(), BaseCRUDEntity_.id, this::buildRangeSpecification)
				                    .and(criteria.getCreatedAt(), BaseCRUDEntity_.createdAt,
				                         this::buildRangeSpecification)
				                    .and(criteria.getUpdatedAt(), BaseCRUDEntity_.updatedAt,
				                         this::buildRangeSpecification)
				                    .and(criteria.getDeletedAt(), BaseCRUDEntity_.deletedAt,
				                         this::buildRangeSpecification)
				                    .and(criteria, this::buildSearchSpecification)
				                    .build();
		
		return findAll.apply(entitySpecification, page);
	}
	
	protected abstract Specification<ENTITY> createSpecification(C criteria);
	
	private Specification<ENTITY> buildSearchSpecification(C criteria) {
		if (StringUtils.isBlank(criteria.getSearch())) {
			return Specification.where(null);
		}
		final var singularAttributes = criteria.searchBy();
		final var specificationBuilder = SpecificationBuilder.<ENTITY>builder();
		singularAttributes.stream().map(
				e -> likeUpperSpecification(entityRoot -> entityRoot.get(e), criteria.getSearch())
		).forEach(specificationBuilder::or);
		return specificationBuilder.build();
	}
}
