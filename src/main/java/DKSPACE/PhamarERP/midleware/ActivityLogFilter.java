package DKSPACE.PhamarERP.midleware;

import DKSPACE.PhamarERP.service.ActivityLogService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ActivityLogFilter extends OncePerRequestFilter {
	private final ActivityLogService activityLogService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws
			ServletException, IOException {
		filterChain.doFilter(request, response);
		try {
			activityLogService.logActivity(request, response);
		} catch (Exception e){
			log.info("ActivityLogService error : {} {} {}", e.getClass(), e.getMessage(), e.getCause());
		}
	}
}
