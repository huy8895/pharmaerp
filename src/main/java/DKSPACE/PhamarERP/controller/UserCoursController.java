package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.master_data.entity.UserCours;
import DKSPACE.PhamarERP.service.UserCoursService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user-cours")
public class UserCoursController extends AbstractBaseCRUDController<UserCours, UserCoursService> {
    protected UserCoursController(UserCoursService service) {
        super(service, UserCours.class);
    }
}
