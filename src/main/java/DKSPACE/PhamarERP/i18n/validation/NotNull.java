package DKSPACE.PhamarERP.i18n.validation;

import DKSPACE.PhamarERP.i18n.constants.ValidateCode;
import DKSPACE.PhamarERP.i18n.validation.validator.NotNullValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Khai báo một custom annotation
 */
@Documented
@Constraint(validatedBy = NotNullValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
    String message() default ValidateCode.NOT_NULL;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

