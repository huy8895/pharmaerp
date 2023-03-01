package DKSPACE.PhamarERP.auth.aop;

import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;

import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HasPermission {
    PermissionKeyEnum[] permissions() default {};
}
