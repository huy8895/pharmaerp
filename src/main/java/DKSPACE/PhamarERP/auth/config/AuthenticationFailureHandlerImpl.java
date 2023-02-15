package DKSPACE.PhamarERP.auth.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler,AuthenticationEntryPoint {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        final var of = Map.of("status", "FALSE", "message", "UNAUTHORIZED");
        log.error(exception.getMessage());
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(mapper.writeValueAsString(of));
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        final var of = Map.of("status", "FALSE", "message", "access denied");
        log.error(exception.getMessage());
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(mapper.writeValueAsString(of));
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Object handleUnauthorized(AuthenticationException exception) {
        log.error("handleUnauthorized: {}", exception.getMessage());
        final var of = Map.of("status", "FALSE", "message", "UNAUTHORIZED");
        log.error(exception.getMessage());
        return of;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleException(Throwable exception) {
        log.error("handleException: {}", exception.getMessage());
        final var of = Map.of("status", "FALSE", "message", "INTERNAL_SERVER_ERROR");
        log.error(exception.getMessage());
        return  of;
    }
}


