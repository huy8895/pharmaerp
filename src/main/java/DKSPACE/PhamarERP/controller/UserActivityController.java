package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserActivityCriteria;
import DKSPACE.PhamarERP.master_data.entity.UserActivity;
import DKSPACE.PhamarERP.service.UserActivityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user-activity")
@ResponseWrapper(excludes = {"exportTemplate", "exportFileExcel"})
@Tag(name = "UserActivity", description = "Các API liên quan đến UserActivity")
public class UserActivityController extends AbstractBaseCRUDController<UserActivity, UserActivityService, UserActivityCriteria> {
	protected UserActivityController(UserActivityService service) {
		super(service, UserActivity.class);
	}
}
