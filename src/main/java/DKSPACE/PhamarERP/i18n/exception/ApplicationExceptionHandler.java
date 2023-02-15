package DKSPACE.PhamarERP.i18n.exception;

import DKSPACE.PhamarERP.i18n.enums.ApiResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ApplicationExceptionHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        ApiResponse<?> serviceResponse = new ApiResponse<>();
        List<ErrorDTO> errors = new ArrayList<>();
        exception.getBindingResult()
                 .getFieldErrors()
                 .forEach(error -> {
                     ErrorDTO errorDT0 = new ErrorDTO(error.getField(), this.getMessageLocale(error.getDefaultMessage()));
                     errors.add(errorDT0);
                 });


        serviceResponse.setStatus(ApiResponseStatus.FAILED);
        serviceResponse.setErrors(errors);
        return serviceResponse;
    }

    private String getMessageLocale(String code) {
        final var locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, locale);
    }
}
