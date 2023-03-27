package DKSPACE.PhamarERP.i18n.validation;


import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
@Documented
public @interface Unique {
	
	String message() default "{custom.validation.constraints.unique.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	String value();
	
	Class<? extends BaseCRUDEntity> domainClass();
}

