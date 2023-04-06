package DKSPACE.PhamarERP.i18n.validation;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class UniquesValidator implements ConstraintValidator<Uniques, BaseCRUDEntity> {
	
	@Autowired
	private EntityManager em;
	private String[] propertyNames;
	private Class<? extends BaseCRUDEntity> entityClass;
	
	@Override
	public void initialize(Uniques unique) {
		propertyNames = unique.values();
		entityClass = unique.domainClass();
	}
	
	@Override
	public boolean isValid(BaseCRUDEntity value, ConstraintValidatorContext context) {
		if (value == null) return true;
		if (this.em == null) return true;
		
		Long id = value.getId();
		final var beanWrapper = new BeanWrapperImpl(value);
		
		
		return Arrays.stream(propertyNames)
		             .allMatch(propertyName -> this.validEachField(context, id, beanWrapper, propertyName));
	}
	
	private Boolean validEachField(ConstraintValidatorContext context,
	                               Long id,
	                               BeanWrapperImpl beanWrapper,
	                               String propertyName) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		final var cq = cb.createQuery(entityClass);
		String message = context.getDefaultConstraintMessageTemplate();
		
		final var entity = cq.from(entityClass);
		final var codePredicate = cb.equal(entity.get(propertyName), beanWrapper.getPropertyValue(propertyName));
		
		cq.where(codePredicate);
		if (id != null) {
			final var idPredicate = cb.notEqual(entity.get("id"), id);
			cq.where(cb.and(idPredicate, codePredicate));
		}
		
		final var query = em.createQuery(cq);
		if (!query.getResultList().isEmpty()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)
			       .addPropertyNode(propertyName)
			       .addConstraintViolation();
			return false;
		}
		return true;
	}
}

