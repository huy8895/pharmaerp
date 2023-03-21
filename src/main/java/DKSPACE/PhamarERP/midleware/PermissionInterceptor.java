package DKSPACE.PhamarERP.midleware;

import DKSPACE.PhamarERP.auth.aop.HasPermission;
import DKSPACE.PhamarERP.auth.config.SecurityUtils;
import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionGroupEnum;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.auth.exception.AccessDeniedException;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.HasBaseCRUDPermission;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import java.util.*;

@Slf4j
@Component
public class PermissionInterceptor implements HandlerInterceptor {
	
	@Override
    public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
        
        log.info("PermissionInterceptor => check");
        if (HandlerMethod.class.isAssignableFrom(handler.getClass())) {
            final var handlerMethod = (HandlerMethod) handler;
            final var hasPermission = handlerMethod.getMethodAnnotation(HasPermission.class);
            final var hasBaseCRUDPermission = handlerMethod.getMethodAnnotation(HasBaseCRUDPermission.class);
            if (hasPermission != null) {
                this.checkPermissionBefore(hasPermission, request);
            } else if (hasBaseCRUDPermission != null) {
                this.checkPermissionBefore(hasBaseCRUDPermission, handlerMethod);
            }
        }
        return true;
    }
    
    private void checkPermissionBefore(HasBaseCRUDPermission crudPermission, HandlerMethod handlerMethod) {
        
        final var actionConfig = crudPermission.value();
        final var groupEnumOptional = PermissionGroupEnum.getGroup(handlerMethod.getBeanType());
        if (groupEnumOptional.isEmpty()) {
            return;
        }
    
        final var permissionGroupEnum = groupEnumOptional.get();
        final var permissionKeyConfig = actionConfig.getPermissionKey(permissionGroupEnum);
    
        User currentUser = SecurityUtils.getCurrentUser();
        
        if (this.isSupperAdmin(currentUser)) {
            return;
        }
    
        final boolean hasPermission = isCurrentUserHasPermission(permissionKeyConfig, currentUser);
    
        if (!hasPermission){
            log.warn("don't has HasBaseCRUDPermission to access this function");
            throw new AccessDeniedException(ApiResponseInfo.FORBIDDEN);
        }
    }
    
    private boolean isCurrentUserHasPermission(String permissionKeyConfig, User currentUser) {
        return currentUser.getRoles()
                          .stream()
                          .map(Role::getPermissions)
                          .flatMap(Collection::stream)
                          .anyMatch(permission -> permissionKeyConfig.equals(permission.getKey()));
    }
    
    public void checkPermissionBefore(HasPermission methodAnnotation, HttpServletRequest request) {
        User currentUser = SecurityUtils.getCurrentUser();

        if (this.isSupperAdmin(currentUser)) {
            return;
        }
    
        final var userIdRequest = this.getUserId(request, "userId");
        final var isCurrentUserRequest = this.isCurrentUser(currentUser, userIdRequest);
        if (isCurrentUserRequest && methodAnnotation.acceptCurrentUser()){
            return;
        }
    
        if (this.hasPermission(methodAnnotation)){
            return;
        }
    
        log.warn("don't has permission to access this function");
        throw new AccessDeniedException(ApiResponseInfo.FORBIDDEN);
    }
    @SuppressWarnings("unchecked")
    public String getUserId(HttpServletRequest request, String key) {
        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        return pathVariables.get(key);
    }
    
    private boolean hasPermission(HasPermission methodAnnotation) {
        Set<String> permission = SecurityUtils.getPermission();
        return this.getPermissions(methodAnnotation).stream()
                   .anyMatch(permissionKeyEnum -> permission
                             .contains(permissionKeyEnum.name()));
    }
    
    private boolean isSupperAdmin(User currentUser) {
        return UserType.SUPER_ADMIN.equals(currentUser.getType());
    }
    
    public List<PermissionKeyEnum> getPermissions(HasPermission methodAnnotation) {
        return Optional.ofNullable(methodAnnotation)
                       .map(HasPermission::value)
                       .map(List::of)
                       .orElse(Collections.emptyList());
    }
    
    /**
     * nếu như id của user đang đăng nhập = với userIdRequest request.
     */
    private boolean isCurrentUser(User currentUser, String userIdRequest) {
        return Objects.equals(currentUser.getId().toString(), userIdRequest);
    }
    
	
}
