package DKSPACE.PhamarERP.auth.config;

import DKSPACE.PhamarERP.auth.model.CustomUserDetails;
import DKSPACE.PhamarERP.auth.model.User;
import org.springframework.security.authentication.BadCredentialsException;
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
        final var principal = SecurityContextHolder.getContext()
                                                   .getAuthentication()
                                                   .getPrincipal();
        
        if (principal instanceof String string && string.equals("anonymousUser")) {
            throw new BadCredentialsException("SecurityUtils getPrincipal anonymousUser");
        }
        return (CustomUserDetails) principal;
    }
    
    public static Long getCurrentUserId(){
        final var principal = SecurityContextHolder.getContext()
                                                   .getAuthentication()
                                                   .getPrincipal();
        if (principal instanceof CustomUserDetails userDetails){
            return userDetails.getUser().getId();
        }
        
        return null;
    }
}
