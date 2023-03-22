package DKSPACE.PhamarERP.general.service.impl;

import DKSPACE.PhamarERP.auth.config.SecurityUtils;
import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.general.criteria.ActivityLogCriteria;
import DKSPACE.PhamarERP.general.model.ActivityLog;
import DKSPACE.PhamarERP.general.repository.ActivityLogRepository;
import DKSPACE.PhamarERP.general.service.ActivityLogService;
import DKSPACE.PhamarERP.general.service.criteria.ActivityLogQueryService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Enumeration;

@Service
@Slf4j
public class ActivityLogServiceImpl extends AbstractBaseCRUDService<ActivityLog, ActivityLogRepository> implements ActivityLogService {
	private final FilterService<ActivityLog,ActivityLogCriteria> queryService;
	
	protected ActivityLogServiceImpl(ActivityLogRepository repository,
	                                 ActivityLogQueryService queryService) {
		super(repository);
		this.queryService = queryService;
	}
	
	@Override
	public Object findByCriteria(Pageable pageable, Criteria<ActivityLog> criteria) {
		if (criteria instanceof ActivityLogCriteria activityLogCriteria) {
			return queryService.findByCriteria(activityLogCriteria, pageable, repository::findAll);
		}
		log.error("findByCriteria criteria must be ActivityLogCriteria");
		throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	public void logActivity(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
		
		final var currentUserId = SecurityUtils.getCurrentUserId();
		if (currentUserId == null) return;
		
		final var requestInfo = this.getRequestInfo(request);
		final var responseInfo = this.getResponseInfo(response);
		
		ActivityLog activityLog = ActivityLog.builder()
		                                     .userId(currentUserId)
		                                     .userAgent(request.getHeader("User-Agent"))
		                                     .ip(request.getRemoteAddr())
		                                     .request(requestInfo)
		                                     .response(responseInfo)
		                                     .build();
		super.save(activityLog);
	}
	
	private String getRequestInfo(HttpServletRequest request) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode rootNode = mapper.createObjectNode();
		rootNode.put("method", request.getMethod());
		rootNode.put("url", request.getRequestURL().toString());
		ObjectNode headersNode = mapper.createObjectNode();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			headersNode.put(headerName, request.getHeader(headerName));
		}
		rootNode.set("headers", headersNode);
		return mapper.writeValueAsString(rootNode);
	}
	
	private String getResponseInfo(HttpServletResponse response) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode rootNode = mapper.createObjectNode();
		rootNode.put("status", response.getStatus());
		ObjectNode headersNode = mapper.createObjectNode();
		Collection<String> headerNames = response.getHeaderNames();
		for (String headerName : headerNames) {
			headersNode.put(headerName, response.getHeader(headerName));
		}
		rootNode.set("headers", headersNode);
		return mapper.writeValueAsString(rootNode);
	}
}