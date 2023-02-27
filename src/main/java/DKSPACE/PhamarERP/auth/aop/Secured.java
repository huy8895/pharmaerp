package DKSPACE.PhamarERP.auth.aop;

import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Secured {
    Class<?>[] group() default {};
}
