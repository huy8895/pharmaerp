package DKSPACE.PhamarERP.helper.query;

import io.github.jhipster.service.filter.Filter;
import org.springframework.data.jpa.domain.Specification;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class SpecificationBuilder<ENTITY> {
	private final AtomicReference<Specification<ENTITY>> specification;
	
	private SpecificationBuilder() {
		this.specification = new AtomicReference<>(Specification.where(null));
	}
	
	
	public static <T> SpecificationBuilder<T> builder() {
		return new SpecificationBuilder<>();
	}
	
	public <FIELD_TYPE, F extends Filter<FIELD_TYPE>> SpecificationBuilder<ENTITY> and(F filter, Function<F, Specification<ENTITY>> function) {
		if (filter != null) {
			this.specification.getAndUpdate(current -> current.and(function.apply(filter)));
		}
		return this;
	}
	
	
	public Specification<ENTITY> build() {
		return this.specification.get();
	}
}
