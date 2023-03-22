package DKSPACE.PhamarERP.general.service;

import DKSPACE.PhamarERP.basecrud.BaseCRUDService;
import DKSPACE.PhamarERP.general.model.ActivityLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ActivityLogService extends BaseCRUDService<ActivityLog> {
	void logActivity(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException;
}