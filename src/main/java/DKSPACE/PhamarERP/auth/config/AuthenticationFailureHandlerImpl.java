package DKSPACE.PhamarERP.auth.config;


import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

@Slf4j
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler,AuthenticationEntryPoint {
    private final I18NMessageResolver messageResolver;
    public AuthenticationFailureHandlerImpl(I18NMessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        log.error("AuthenticationFailureHandlerImpl onAuthenticationFailure: path: {}, error: {}", request.getRequestURI(), exception.getMessage());
        this.responseUnauthorized(response);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        log.error("AuthenticationFailureHandlerImpl commence: path: {}, error: {}", request.getRequestURI(), exception.getMessage());
        this.responseUnauthorized(response);
    }
    
    private void responseUnauthorized(HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final var unauthorized = HttpStatus.UNAUTHORIZED;
        response.setStatus(unauthorized.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        final var apiResponse = messageResolver.generateApiResponse(ApiResponseInfo.UNAUTHORIZED);
        apiResponse.setStatus(unauthorized.name());
        apiResponse.setStatusCode(unauthorized.value());
        response.getWriter().write(mapper.writeValueAsString(apiResponse));
    }
}


