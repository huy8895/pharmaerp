package DKSPACE.PhamarERP.midleware;

import DKSPACE.PhamarERP.auth.aop.HasPermission;
import DKSPACE.PhamarERP.auth.config.SecurityUtils;
import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.auth.exception.AccessDeniedException;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Parameter;
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
            final var methodAnnotation = handlerMethod.getMethodAnnotation(HasPermission.class);
            if (methodAnnotation == null) return true;
            
            this.checkPermissionBefore(request, methodAnnotation);
        }
        return true;
    }
    public void checkPermissionBefore(HttpServletRequest request, HasPermission methodAnnotation) {
        
        User currentUser = SecurityUtils.getCurrentUser();
        if (this.isSupperAdmin(currentUser)) {
            return;
        }
    
    
        if (this.hasPermission(methodAnnotation)){
            return;
        }
    
        log.warn("don't has permission to access this function");
        throw new AccessDeniedException(ApiResponseInfo.FORBIDDEN);
    }
    
    @SuppressWarnings("unchecked")
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
    
    //todo tạo 1 annotation để validate currentUser.
    /**
     * nếu như id của user đang đăng nhập = với userId request.
     */
    private boolean acceptCurrentUser(HandlerMethod handler) {
        final HasPermission hasPermission = handler.getMethodAnnotation(HasPermission.class);
        
        Object[] args = handler.getMethod().getParameters();
//        String[] parameterNames = handler.getMethod().getParameters();
        String[] parameterNames = new String[]{};
    
        // Assuming you have a HandlerMethod object named handler
        Parameter[] params = handler.getMethod().getParameters();
        for (Parameter p : params) {
            // Get the name of the parameter
            String name = p.getName();
        
            // Get the value of the parameter
            Object value = p ;// args is an array of arguments passed to the method
            System.out.println("Value: " + value);
        }
    
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        for (int i = 0; i < args.length; i ++) {
            evaluationContext.setVariable(parameterNames[i], args[i]);
        }
    
        final var parser = new SpelExpressionParser();
    
        Long userId = parser.parseExpression(hasPermission.userId(), new TemplateParserContext())
                            .getValue(evaluationContext, Long.class);
    
        User currentUser = SecurityUtils.getCurrentUser();
        return Objects.equals(currentUser.getId(), userId);
    }
    
	
}
