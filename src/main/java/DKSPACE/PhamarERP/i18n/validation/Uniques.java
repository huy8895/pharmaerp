package DKSPACE.PhamarERP.i18n.validation;


import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquesValidator.class)
@Documented
public @interface Uniques {
	
	String message() default "{custom.validation.constraints.unique.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	String[] values();
	
	Class<? extends BaseCRUDEntity> domainClass();
}

