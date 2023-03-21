package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCertificateCriteria;
import DKSPACE.PhamarERP.master_data.entity.UserCertificate;
import DKSPACE.PhamarERP.service.UserCertificateService;
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
