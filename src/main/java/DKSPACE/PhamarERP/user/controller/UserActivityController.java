package DKSPACE.PhamarERP.user.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.user.dto.criteria.UserActivityCriteria;
import DKSPACE.PhamarERP.user.model.UserActivity;
import DKSPACE.PhamarERP.user.service.UserActivityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user-activities")
@ResponseWrapper
@Tag(name = "UserActivity", description = "Hoạt động của người dùng")
public class UserActivityController extends AbstractBaseCRUDController<UserActivity, UserActivityService, UserActivityCriteria> {
	protected UserActivityController(UserActivityService service) {
		super(service, UserActivity.class);
	}
}