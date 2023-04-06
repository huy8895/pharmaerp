package DKSPACE.PhamarERP.i18n.validation;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniquesValidator implements ConstraintValidator<Uniques, Object> {
	
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
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value == null) return true;
		if (this.em == null) return true;
		boolean isValid = false;
		
		if (!isValid) {
			String message = context.getDefaultConstraintMessageTemplate();
			
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)
			       .addPropertyNode(propertyNames[0])
			       .addConstraintViolation()
			       .buildConstraintViolationWithTemplate(message)
			       .addPropertyNode(propertyNames[1])
			       .addConstraintViolation();
		}
		
		return isValid;
	}
}

