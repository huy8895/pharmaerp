package DKSPACE.PhamarERP.controller.crm;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmContactCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmContact;
import DKSPACE.PhamarERP.service.CrmContactService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/crm-contacts")
@ResponseWrapper
@Tag(name = "CrmContact", description = "Liên hệ của công ty")
public class CrmContactController extends AbstractBaseCRUDController<CrmContact, CrmContactService, CrmContactCriteria> {
	protected CrmContactController(CrmContactService service) {
		super(service, CrmContact.class);
	}
}
