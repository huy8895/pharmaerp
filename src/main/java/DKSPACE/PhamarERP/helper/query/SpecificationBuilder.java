package DKSPACE.PhamarERP.helper.query;

import io.github.jhipster.service.filter.Filter;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SpecificationBuilder<ENTITY> {
	private final AtomicReference<Specification<ENTITY>> specification;
	
	private SpecificationBuilder() {
		this.specification = new AtomicReference<>(Specification.where(null));
	}
	
	public SpecificationBuilder(Specification<ENTITY> specification) {
		this.specification = new AtomicReference<>(specification);
	}
	
	public static <T> SpecificationBuilder<T> builder() {
		return new SpecificationBuilder<>();
	}
	
	public static <T> SpecificationBuilder<T> from(Specification<T> specification) {
		return new SpecificationBuilder<>(specification);
	}
	
	public <FIELD_TYPE, F extends Filter<FIELD_TYPE>> SpecificationBuilder<ENTITY> and(F filter, Function<F, Specification<ENTITY>> function) {
		if (filter != null) {
			this.specification.getAndUpdate(current -> current.and(function.apply(filter)));
		}
		return this;
	}
	
	public <FIELD_TYPE, X, F extends Filter<FIELD_TYPE>> SpecificationBuilder<ENTITY> and(F filter,
	                                                                                      SingularAttribute<? super ENTITY, X> field,
	                                                                                      BiFunction<F, SingularAttribute<? super ENTITY, X>, Specification<ENTITY>> function) {
		if (filter != null) {
			this.specification.getAndUpdate(current -> current.and(function.apply(filter, field)));
		}
		return this;
	}
	
	public <FIELD_TYPE, X, F extends Filter<FIELD_TYPE>> SpecificationBuilder<ENTITY> and(F filter,
	                                                                                      Function<Root<ENTITY>, Expression<X>> metaclassFunction,
	                                                                                      BiFunction<F, Function<Root<ENTITY>, Expression<X>>, Specification<ENTITY>> function) {
		if (filter != null) {
			this.specification.getAndUpdate(current -> current.and(function.apply(filter, metaclassFunction)));
		}
		return this;
	}
	
	
	public Specification<ENTITY> build() {
		return this.specification.get();
	}
}
