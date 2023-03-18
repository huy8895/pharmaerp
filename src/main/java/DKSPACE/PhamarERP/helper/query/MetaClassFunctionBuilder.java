package DKSPACE.PhamarERP.helper.query;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MetaClassFunctionBuilder<ENTITY, X> {
	Function<Root<ENTITY>, Expression<X>> metaclassFunction;
	private final AtomicReference<Specification<ENTITY>> specificationRef;
	
	
	public MetaClassFunctionBuilder(Function<Root<ENTITY>, Expression<X>> metaclassFunction) {
		this.metaclassFunction = metaclassFunction;
		this.specificationRef = new AtomicReference<>(Specification.where(null));
	}
	
	public static <ENTITY, X> MetaClassFunctionBuilder<ENTITY, X> builder(Function<Root<ENTITY>, Expression<X>> metaclassFunction){
		return new MetaClassFunctionBuilder<>(metaclassFunction);
	}
	

	
	public MetaClassFunctionBuilder<ENTITY, X> and(X notEquals, BiFunction<Function<Root<ENTITY>, Expression<X>>,X , Specification<ENTITY>> biFunction) {
		if (notEquals == null) return this;
		specificationRef.getAndUpdate(entitySpecification -> entitySpecification.and(biFunction.apply(metaclassFunction, notEquals)));
		return this;
	}
	
	public MetaClassFunctionBuilder<ENTITY, X> and(Boolean notEquals, BiFunction<Function<Root<ENTITY>, Expression<X>>, Boolean , Specification<ENTITY>> biFunction) {
		if (notEquals == null) return this;
		specificationRef.getAndUpdate(entitySpecification -> entitySpecification.and(biFunction.apply(metaclassFunction, notEquals)));
		return this;
	}
	
	public MetaClassFunctionBuilder<ENTITY, X> and(List<X> notEquals, BiFunction<Function<Root<ENTITY>, Expression<X>>, List<X> , Specification<ENTITY>> biFunction) {
		if (notEquals == null) return this;
		specificationRef.getAndUpdate(entitySpecification -> entitySpecification.and(biFunction.apply(metaclassFunction, notEquals)));
		return this;
	}
	
	public Specification<ENTITY> build() {
		return this.specificationRef.get();
	}
}
