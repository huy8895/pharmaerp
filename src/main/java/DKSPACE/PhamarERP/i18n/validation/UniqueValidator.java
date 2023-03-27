package DKSPACE.PhamarERP.i18n.validation;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {
	
	private final EntityManager em;
	private String fieldName;
	private Class<? extends BaseCRUDEntity> entityClass;
	
	public UniqueValidator(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	@Override
	public void initialize(Unique unique) {
		fieldName = unique.value();
		entityClass = unique.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value == null) return true;
		
		try {
			
			// Bước 1: Tạo CriteriaBuilder
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			// Bước 2: Tạo CriteriaQuery
			final var cq = cb.createQuery(entityClass);
			
			// Bước 3: Tạo Root
			final var product = cq.from(entityClass);
			
			// Bước 4: Tạo Predicate
			final var codePredicate = cb.equal(product.get(fieldName), value);
			
			// Bước 5: Gán Predicate vào CriteriaQuery
			cq.where(codePredicate);
			
			// Bước 6: Tạo TypedQuery
			final var query = em.createQuery(cq);
			
			// Bước 7: Lấy kết quả
			final var result = query.getResultList();
			
			return result.isEmpty();
		} catch (Exception e) {
			return false;
		}
		
	}
}

