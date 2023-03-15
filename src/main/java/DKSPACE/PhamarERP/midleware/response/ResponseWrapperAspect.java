package DKSPACE.PhamarERP.midleware.response;

import DKSPACE.PhamarERP.i18n.exception.ApiResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ResponseWrapperAspect {
	
	@Around("@within(responseWrapper)")
	public Object wrapResponse(ProceedingJoinPoint joinPoint, ResponseWrapper responseWrapper) throws Throwable {
		// Get the result of the method invocation
		Object result = joinPoint.proceed();
		
		// Get the current method name
		String methodName = joinPoint.getSignature().getName();
		
		// Get the array of excluded methods from the annotation
		String[] excludes = responseWrapper.excludes();
		
		// Check if the current method is in the excluded array
		boolean isExcluded = Arrays.asList(excludes).contains(methodName);
		
		// If the current method is excluded, return the original result
		if (isExcluded) {
			return result;
		}
		
		return ResponseEntity.ok(result);
	}
}
