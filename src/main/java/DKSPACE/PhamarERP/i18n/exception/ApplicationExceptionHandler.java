package DKSPACE.PhamarERP.i18n.exception;

import DKSPACE.PhamarERP.auth.exception.UserAlreadyExistException;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ApplicationExceptionHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Object handleUnauthorized(AuthenticationException exception) {
        log.error("handleUnauthorized: {}", exception.getMessage());
        final var of = Map.of("status", "FALSE", "message", "unauthorized");
        log.error(exception.getMessage());
        return of;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleException(Throwable exception) {
        log.error("handleException: {}", exception.getMessage());
        final var of = Map.of("status", "FALSE", "message", "internal server error");
        log.error(exception.getMessage());
        return  of;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("handleException: {}", exception.getMessage());
        final var of = Map.of("status", "FALSE", "message", "BAD_REQUEST");
        log.error(exception.getMessage());
        return  of;
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleBadCredentialsException(BadCredentialsException exception) {
        log.error("handleBadCredentialsException: {}", exception.getMessage());
        final var of = Map.of("status", "FALSE", "message", "bad credentials");
        log.error(exception.getMessage());
        return  of;
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleUserAlreadyExistException(UserAlreadyExistException exception) {
        log.error("handleUserAlreadyExistException: {}", exception.getMessage());
        final var of = Map.of("status", "FALSE", "message", "user already exist");
        log.error(exception.getMessage());
        return  of;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        ApiResponse<?> apiResponse = new ApiResponse<>();
        List<ErrorDTO> errors = new ArrayList<>();
        exception.getBindingResult()
                 .getFieldErrors()
                 .forEach(error -> {
                     ErrorDTO errorDT0 = new ErrorDTO(error.getField(), this.getMessageLocale(error.getDefaultMessage()));
                     errors.add(errorDT0);
                 });

        apiResponse.setStatus(ApiResponseStatus.FAILED);
        apiResponse.setErrors(errors);
        return apiResponse;
    }

    private String getMessageLocale(String code) {
        final var locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, locale);
    }
}
