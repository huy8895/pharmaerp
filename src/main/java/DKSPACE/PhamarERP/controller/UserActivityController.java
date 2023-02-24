package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.master_data.entity.UserActivity;
import DKSPACE.PhamarERP.service.UserActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user-activity")
public class UserActivityController extends AbstractBaseCRUDController<UserActivity, UserActivityService> {
    protected UserActivityController(UserActivityService service) {
        super(service, UserActivity.class);
    }
}
