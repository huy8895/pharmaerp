package DKSPACE.PhamarERP.user.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.user.dto.criteria.UserCoursCriteria;
import DKSPACE.PhamarERP.user.model.UserCours;
import DKSPACE.PhamarERP.user.service.UserCoursService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user-cours")
@ResponseWrapper
@Tag(name = "UserCours", description = "Khóa học")
public class UserCoursController extends AbstractBaseCRUDController<UserCours, UserCoursService, UserCoursCriteria> {
	protected UserCoursController(UserCoursService service) {
		super(service, UserCours.class);
	}
}
