package DKSPACE.PhamarERP.general.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.general.criteria.ActivityLogCriteria;
import DKSPACE.PhamarERP.general.model.ActivityLog;
import DKSPACE.PhamarERP.general.service.ActivityLogService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
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