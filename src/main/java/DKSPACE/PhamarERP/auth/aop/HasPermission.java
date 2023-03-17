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
     * cho phép người dùng hiện tại truy cập mà không cần kiểm tra quyền
     */
    boolean acceptCurrentUser() default false;
}
