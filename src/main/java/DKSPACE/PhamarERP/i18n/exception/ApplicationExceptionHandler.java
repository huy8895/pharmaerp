package DKSPACE.PhamarERP.i18n.exception;

import DKSPACE.PhamarERP.auth.exception.AccessDeniedException;
import DKSPACE.PhamarERP.auth.exception.UserAlreadyExistException;
import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ServerWebInputException;

import java.util.Locale;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
@ResponseWrapper
public class ApplicationExceptionHandler {
    private final I18NMessageResolver messageResolver;

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponse<?> handleUnauthorized(AuthenticationException exception) {
        log.error("handleUnauthorized: {}", exception.getMessage());
        return ApiResponse.failed(ApiResponseInfo.UNAUTHORIZED);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<?> handleException(Throwable exception) {
        log.error("handleException: {}", exception.getMessage());
        log.error("handleException class: {}", exception.getClass());
        return ApiResponse.failed(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleNoValuePresent(NoSuchElementException exception) {
        log.error("handleNoValuePresent: {}", exception.getMessage());
        return ApiResponse.failed(ApiResponseInfo.NO_VALUE_PRESENT);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException exception) {
        log.error("handleMaxUploadSizeExceededException: {}", exception.getMessage());
        return ApiResponse.failed(ApiResponseInfo.MAX_UPLOAD_SIZE_EXCEEDED);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("handleHttpMessageNotReadableException: {}", exception.getMessage());
        return ApiResponse.failed(ApiResponseInfo.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleBadCredentialsException(BadCredentialsException exception) {
        log.error("handleBadCredentialsException: {}", exception.getMessage());
        log.error(exception.getMessage());
        return ApiResponse.failed(ApiResponseInfo.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleUserAlreadyExistException(UserAlreadyExistException exception) {
        log.error("handleUserAlreadyExistException: {}", exception.getMessage());
        log.error(exception.getMessage());
        return ApiResponse.failed(ApiResponseInfo.USER_ALREADY_EXIST);
    }

    @ExceptionHandler(ClientException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleClientException(ClientException exception) {
        log.error("handleClientException: {}", exception.getMessage());
        log.error(exception.getMessage());
        return ApiResponse.failed(exception.getApiResponseInfo());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        log.error("handleMethodNotSupportedException: {}", exception.getClass());
        log.error(exception.getMessage());
        return ApiResponse.failed(ApiResponseInfo.METHOD_NOT_SUPPORTED);
    }
    
    @ExceptionHandler(MethodNotAllowedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResponse<?> handleMethodNotAllowedException(MethodNotAllowedException exception) {
        log.error("handleMethodNotSupportedException: {}", exception.getClass());
        log.error(exception.getMessage());
        return ApiResponse.failed(ApiResponseInfo.FORBIDDEN);
    }
    
    @ExceptionHandler(ServerWebInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleServerWebInputException(ServerWebInputException exception) {
        log.error("handleServerWebInputException: {}", exception.getClass());
        log.error(exception.getMessage());
        return ApiResponse.failed(ApiResponseInfo.BAD_REQUEST);
    }
    
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResponse<?> handleAccessDeniedException(AccessDeniedException exception) {
        log.error("handleAccessDeniedException: {}", exception.getMessage());
        log.error(exception.getMessage());
        return ApiResponse.failed(exception.getApiResponseInfo());
    }

    @ExceptionHandler(ServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<?> handleServerException(ServerException exception) {
        log.error("handleServerException: {}", exception.getMessage());
        log.error(exception.getMessage());
        return ApiResponse.failed(exception.getApiResponseInfo());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        final var apiResponse = ApiResponse.failed(ApiResponseInfo.BAD_REQUEST);
        final var  errors =
                exception.getBindingResult()
                         .getFieldErrors()
                         .stream()
                         .map(error -> ErrorDTO.builder()
                                               .field(error.getField())
                                               .errorMessage(error.getDefaultMessage())
                                               .build())
                         .toList();

        apiResponse.setErrors(errors);
        return apiResponse;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiResponse<?> handleConstraintViolationException(
            ConstraintViolationException exception) {
        log.error("handleConstraintViolationException exception: ", exception);
        final var apiResponse = ApiResponse.failed(ApiResponseInfo.BAD_REQUEST);
        final var errors =
                exception.getConstraintViolations()
                         .stream()
                         .map(error -> ErrorDTO.builder()
                                               .field(error.getPropertyPath().toString())
                                               .errorMessage(error.getMessage())
                                               .build())
                         .toList();
        
        apiResponse.setErrors(errors);
        return apiResponse;
    }
}
