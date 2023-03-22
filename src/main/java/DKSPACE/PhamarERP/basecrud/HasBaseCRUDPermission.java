package DKSPACE.PhamarERP.basecrud;

import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HasBaseCRUDPermission {
    BaseCRUDAction value() ;
}
