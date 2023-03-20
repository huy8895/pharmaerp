package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCoursCriteria;
import DKSPACE.PhamarERP.master_data.entity.UserCours;
import DKSPACE.PhamarERP.service.UserCoursService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user-cours")
@ResponseWrapper(excludes = {"exportTemplate", "exportFileExcel"})
@Tag(name = "UserCours", description = "Các API liên quan đến UserCours")
public class UserCoursController extends AbstractBaseCRUDController<UserCours, UserCoursService, UserCoursCriteria> {
	protected UserCoursController(UserCoursService service) {
		super(service, UserCours.class);
	}
}
