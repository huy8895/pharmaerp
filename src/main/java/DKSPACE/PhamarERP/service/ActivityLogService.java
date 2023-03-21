package DKSPACE.PhamarERP.service;

import DKSPACE.PhamarERP.basecrud.BaseCRUDService;
import DKSPACE.PhamarERP.master_data.entity.ActivityLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ActivityLogService extends BaseCRUDService<ActivityLog> {
	void logActivity(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException;
}