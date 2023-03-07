package DKSPACE.PhamarERP.auth.aop;

import DKSPACE.PhamarERP.auth.config.SecurityUtils;
import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.auth.exception.AccessDeniedException;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class SecuredAspect {


	@Before(value = "@annotation(DKSPACE.PhamarERP.auth.aop.HasPermission)")
	public void before(JoinPoint joinPoint) {

		User currentUser = SecurityUtils.getCurrentUser();
		if (this.isSupperAdmin(currentUser)) {
			return;
		}
		
		if (this.acceptCurrentUser(joinPoint)){
			return;
		}

		if (this.hasPermission(joinPoint)){
			return;
		}

		log.warn("don't has permission to access this function");
		throw new AccessDeniedException(ApiResponseInfo.FORBIDDEN);
	}

	@SuppressWarnings("unchecked")
	private boolean hasPermission(JoinPoint joinPoint) {
		Set<String> permission = SecurityUtils.getPermission();
		return Stream.of(this.getPermissions(joinPoint))
					 .anyMatch(permissionKeyEnum -> permission
											 .contains(permissionKeyEnum.name()));
	}

	private boolean isSupperAdmin(User currentUser) {
		return UserType.SUPER_ADMIN.equals(currentUser.getType());
	}

	public PermissionKeyEnum[] getPermissions(JoinPoint j) {
		final HasPermission s = this.getAnnotation(j);
		return s.value();
	}
	
	/**
	 * nếu như id của user đang đăng nhập = với userId request.
	 */
	private boolean acceptCurrentUser(JoinPoint joinPoint) {
		final HasPermission hasPermission = this.getAnnotation(joinPoint);
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		Object[] args = joinPoint.getArgs();
		String[] parameterNames = signature.getParameterNames();
		
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
	
	private HasPermission getAnnotation(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		return method.getAnnotation(HasPermission.class);
	}
}
