package DKSPACE.PhamarERP.user.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.user.dto.criteria.UserCertificateCriteria;
import DKSPACE.PhamarERP.user.model.UserCertificate;
import DKSPACE.PhamarERP.user.service.UserCertificateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user-certificates")
@ResponseWrapper
@Tag(name = "UserCertificate", description = "Chứng chỉ của người dùng")
public class UserCertificateController extends AbstractBaseCRUDController<UserCertificate, UserCertificateService, UserCertificateCriteria> {
	protected UserCertificateController(UserCertificateService service) {
		super(service, UserCertificate.class);
	}
}
