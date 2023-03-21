package DKSPACE.PhamarERP.i18n.response;

import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import DKSPACE.PhamarERP.i18n.exception.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

@Component
@Aspect
@RequiredArgsConstructor
public class ResponseWrapperAspect {
	private final I18NMessageResolver messageResolver;
	
	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)" +
			" || within(DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController)")
	public void controller() {
		// Method is empty as this is just a Pointcut, the implementations are in the advices.
	}
	
	@Pointcut("within(@org.springframework.web.bind.annotation.RestControllerAdvice *)")
	public void controllerAdvice() {
		// Method is empty as this is just a Pointcut, the implementations are in the advices.
	}
	
	@Around("@within(responseWrapper) && controllerAdvice()")
	public Object wrapResponseAdvice(ProceedingJoinPoint joinPoint, ResponseWrapper responseWrapper) throws Throwable {
		if (this.isExcluded(responseWrapper, joinPoint)) return joinPoint.proceed();
		// Get the result of the method invocation
		Object result = joinPoint.proceed();
		
		// Lấy đối tượng MethodSignature từ joinPoint
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		// Lấy đối tượng Method từ signature
		Method method = signature.getMethod();
		
		ResponseStatus responseStatus = method.getAnnotation(ResponseStatus.class);
		// Lấy giá trị trong ResponseStatus
		HttpStatus httpStatus = responseStatus.value();
		final var response = (ApiResponse<?>) result;
		Optional.ofNullable(response.getResponseInfo())
		        .map(messageResolver::convertMessage)
		        .ifPresent(response::setMessage);
		response.setStatus(httpStatus.name());
		response.setStatusCode(httpStatus.value());
		return response;
	}
	
	@Around("@within(responseWrapper) && controller()")
	public Object wrapResponse(ProceedingJoinPoint joinPoint, ResponseWrapper responseWrapper) throws Throwable {
		if (this.isExcluded(responseWrapper, joinPoint)) return joinPoint.proceed();
		
		// Get the result of the method invocation
		Object result = joinPoint.proceed();
		
		if (result instanceof ResponseEntity<?> responseEntity){
			return ApiResponse.ok(responseEntity.getBody());
		}
		return ApiResponse.ok(result);
	}
	
	private boolean isExcluded(ResponseWrapper responseWrapper, ProceedingJoinPoint joinPoint) {
		// Lấy đối tượng Method từ signature
		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
		
		// If the current method is excluded, return the original result
		return Arrays.asList(responseWrapper.excludes())
		             .contains(method.getName());
	}
}
