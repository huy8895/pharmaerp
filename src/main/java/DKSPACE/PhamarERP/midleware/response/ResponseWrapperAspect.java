package DKSPACE.PhamarERP.midleware.response;

import DKSPACE.PhamarERP.i18n.exception.ApiResponse;
import DKSPACE.PhamarERP.i18n.exception.ApplicationExceptionHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
public class ResponseWrapperAspect {
	
	@Around("@within(responseWrapper)")
	public Object wrapResponse(ProceedingJoinPoint joinPoint, ResponseWrapper responseWrapper) throws Throwable {
		// Get the result of the method invocation
		Object result = joinPoint.proceed();
		
		// Lấy đối tượng MethodSignature từ joinPoint
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		// Lấy đối tượng Method từ signature
		Method method = signature.getMethod();
		
		// Get the array of excluded methods from the annotation
		String[] excludes = responseWrapper.excludes();
		
		// Check if the current method is in the excluded array
		String methodName = method.getName();
		boolean isExcluded = Arrays.asList(excludes).contains(methodName);
		
		// If the current method is excluded, return the original result
		if (isExcluded) {
			return result;
		}
		
		Object target = joinPoint.getTarget();
		if (target instanceof ApplicationExceptionHandler ){
			ResponseStatus responseStatus = method.getAnnotation(ResponseStatus.class);
			// Lấy giá trị trong ResponseStatus
			HttpStatus httpStatus = responseStatus.value();
			final var response = (ApiResponse<?>) result;
			response.setStatus(httpStatus.name());
			response.setStatusCode(httpStatus.value());
			return response;
		}
		// Lấy đối tượng ResponseStatus từ method
		
		if (result instanceof ResponseEntity<?> responseEntity){
			return ApiResponse.ok(responseEntity.getBody());
		}
		return ApiResponse.ok(result);
	}
}
