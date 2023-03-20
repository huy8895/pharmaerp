package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.dto.criteria.ActivityLogCriteria;
import DKSPACE.PhamarERP.master_data.entity.ActivityLog;
import DKSPACE.PhamarERP.service.ActivityLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/activity-logs")
@ResponseWrapper
@Tag(name = "ActivityLog", description = "Hoạt động của người dùng")
public class ActivityLogController
		extends AbstractBaseCRUDController<ActivityLog, ActivityLogService, ActivityLogCriteria> {
	
	protected ActivityLogController(ActivityLogService service) {
		super(service,  ActivityLog.class);
	}
}