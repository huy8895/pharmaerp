package DKSPACE.PhamarERP.auth.aop;

import DKSPACE.PhamarERP.auth.config.JwtService;
import DKSPACE.PhamarERP.auth.config.SecurityUtils;
import DKSPACE.PhamarERP.auth.enums.UserType;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.auth.exception.AccessDeniedException;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Stream;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class SecuredAspect {

	private final JwtService jwtService;
	private final HttpServletRequest httpServlet;


	@Before(value = "@annotation(DKSPACE.PhamarERP.auth.aop.HasPermission)")
	public void before(JoinPoint joinPoint) {

		User currentUser = SecurityUtils.getCurrentUser();
		if (this.isSupperAdmin(currentUser)) {
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
		MethodSignature signature = (MethodSignature) j.getSignature();
		Method method = signature.getMethod();
		final var s = method.getAnnotation(HasPermission.class);
		return s.value();
	}

}
