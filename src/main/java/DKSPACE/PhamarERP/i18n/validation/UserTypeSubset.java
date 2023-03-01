package DKSPACE.PhamarERP.i18n.validation;

import DKSPACE.PhamarERP.auth.enums.UserType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = UserTypeSubSetValidator.class)
public @interface UserTypeSubset {
    UserType[] anyOf() default {};
    UserType[] noneOf() default {};

    String message() default "{custom.validation.constraints.UserType.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
