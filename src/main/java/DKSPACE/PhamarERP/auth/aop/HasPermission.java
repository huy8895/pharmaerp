package DKSPACE.PhamarERP.auth.aop;

import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;

import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HasPermission {
    /**
     * chỉ những user có quyền tương ứng mới được phép access.
     */
    PermissionKeyEnum[] value() default {};
    
    /**
     * userId request <p>
     * SpEL default ex: #{#dto.id}
     */
    String userId() default "";
}
