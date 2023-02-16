package DKSPACE.PhamarERP.i18n.exception;

import DKSPACE.PhamarERP.auth.exception.UserAlreadyExistException;
import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ApplicationExceptionHandler {
    private final I18NMessageResolver messageResolver;

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponse<?> handleUnauthorized(AuthenticationException exception) {
        log.error("handleUnauthorized: {}", exception.getMessage());
        return messageResolver.generateApiResponse(ApiResponseInfo.UNAUTHORIZED);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<?> handleException(Throwable exception) {
        log.error("handleException: {}", exception.getMessage());
        return messageResolver.generateApiResponse(ApiResponseInfo.UNAUTHORIZED);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("handleException: {}", exception.getMessage());
        return messageResolver.generateApiResponse(ApiResponseInfo.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleBadCredentialsException(BadCredentialsException exception) {
        log.error("handleBadCredentialsException: {}", exception.getMessage());
        final var of = Map.of("status", "FALSE", "message", "bad credentials");
        log.error(exception.getMessage());
        return messageResolver.generateApiResponse(ApiResponseInfo.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleUserAlreadyExistException(UserAlreadyExistException exception) {
        log.error("handleUserAlreadyExistException: {}", exception.getMessage());
        final var of = Map.of("status", "FALSE", "message", "user already exist");
        log.error(exception.getMessage());
        return messageResolver.generateApiResponse(ApiResponseInfo.USER_ALREADY_EXIST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        ApiResponse<?> apiResponse = new ApiResponse<>();
        List<ErrorDTO> errors =
                exception.getBindingResult()
                         .getFieldErrors()
                         .stream()
                         .map(error -> ErrorDTO.builder()
                                               .field(error.getField())
                                               .errorMessage(messageResolver.convertMessage(error.getDefaultMessage()))
                                               .build())
                         .collect(Collectors.toList());

        apiResponse.setStatus(ApiResponseStatus.FAILED);
        apiResponse.setErrors(errors);
        return apiResponse;
    }
}
