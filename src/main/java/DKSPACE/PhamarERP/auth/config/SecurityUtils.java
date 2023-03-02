package DKSPACE.PhamarERP.auth.config;

import DKSPACE.PhamarERP.auth.model.CustomUserDetails;
import DKSPACE.PhamarERP.auth.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Set;

public final class SecurityUtils {
    public static User getCurrentUser(){
        return getPrincipal().getUser();
    }

    public static Set<String> getPermission(){
        return getPrincipal().getCredentials();
    }

    public static CustomUserDetails getPrincipal() {
        return (CustomUserDetails) SecurityContextHolder.getContext()
                                                        .getAuthentication()
                                                        .getPrincipal();
    }
}
