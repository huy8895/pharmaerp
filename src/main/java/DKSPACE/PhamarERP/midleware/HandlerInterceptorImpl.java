package DKSPACE.PhamarERP.midleware;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HandlerInterceptorImpl implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        log.info("[preHandle] ==> {}", this.getLogMessage(request, response, handler));

        return true;
    }
    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (ex != null){
            ex.printStackTrace();
        }
        log.info("[afterCompletion] ==> {}", this.getLogMessage(request, response, handler));
    }

    private LogDTO getLogMessage(HttpServletRequest request, HttpServletResponse response, Object handler) {
        LogDTO message = new LogDTO();
        message.setHttpStatus(response.getStatus());
        message.setHttpMethod(request.getMethod());
        message.setPath(request.getRequestURI());
        message.setClientIp(request.getRemoteAddr());
        message.setJavaMethod(handler.toString());
        message.setResponse(this.getResponsePayload(response));
        message.setHeaders(this.getHeaderFromRequest(request));
        return message;
    }

    private Map<String, String> getHeaderFromRequest(HttpServletRequest httpRequest) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> headerNames = httpRequest.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                final var key = headerNames.nextElement();
                map.put(key, httpRequest.getHeader(key));
            }
        }
        return map;
    }

    private String getResponsePayload(HttpServletResponse response) {
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                int length = Math.min(buf.length, 5120);
                try {
                    return new String(buf, 0, length, wrapper.getCharacterEncoding());
                }
                catch (UnsupportedEncodingException ex) {
                    // NOOP
                }
            }
        }
        return "[unknown]";
    }
}
