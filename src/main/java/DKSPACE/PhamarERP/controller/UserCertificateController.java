package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.master_data.entity.UserCertificate;
import DKSPACE.PhamarERP.service.UserCertificateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user-certificate")
public class UserCertificateController extends AbstractBaseCRUDController<UserCertificate, UserCertificateService> {
    protected UserCertificateController(UserCertificateService service) {
        super(service, UserCertificate.class);
    }
}
