package DKSPACE.PhamarERP.i18n.validation;

import DKSPACE.PhamarERP.i18n.constants.ValidateCode;
import DKSPACE.PhamarERP.i18n.validation.validator.NotBlankValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Khai báo một custom annotation
 */
@Documented
@Constraint(validatedBy = NotBlankValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {

    String message() default ValidateCode.NOT_EMPTY;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

