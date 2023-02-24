package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.master_data.entity.UserProfile;
import DKSPACE.PhamarERP.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user-profile")
public class UserProfileController extends AbstractBaseCRUDController<UserProfile, UserProfileService> {
    protected UserProfileController(UserProfileService service) {
        super(service, UserProfile.class);
    }
}
