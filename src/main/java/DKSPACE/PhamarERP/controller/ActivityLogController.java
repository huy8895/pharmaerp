package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.entity.ActivityLog;
import DKSPACE.PhamarERP.service.ActivityLogService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/activity-logs")
@ResponseWrapper
@Tag(name = "ActivityLog", description = "Các API liên quan đến nhật ký hoạt động của người dùng")
public class ActivityLogController extends AbstractBaseCRUDController<ActivityLog, ActivityLogService> {
	
	protected ActivityLogController(ActivityLogService service) {
		super(service,  ActivityLog.class);
	}

}