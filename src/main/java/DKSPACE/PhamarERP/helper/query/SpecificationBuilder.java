package DKSPACE.PhamarERP.helper.query;

import io.github.jhipster.service.filter.Filter;
import org.springframework.data.jpa.domain.Specification;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class SpecificationBuilder<T> {
	private final AtomicReference<Specification<T>> specification;
	
	private SpecificationBuilder() {
		this.specification = new AtomicReference<>(Specification.where(null));
	}
	
	
	public static <T> SpecificationBuilder<T> builder() {
		return new SpecificationBuilder<>();
	}
	
	public <X> SpecificationBuilder<T> and(Filter<X> filter, Function<Filter<X>, Specification<T>> function) {
		if (filter != null) {
			this.specification.getAndUpdate(current -> current.and(function.apply(filter)));
		}
		return this;
	}
	
	public Specification<T> build() {
		return this.specification.get();
	}
}
