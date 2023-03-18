package DKSPACE.PhamarERP.i18n.response;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface ResponseWrapper {
	String[] excludes() default {};
}