package DKSPACE.PhamarERP.crm.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.crm.criteria.CrmContactCriteria;
import DKSPACE.PhamarERP.crm.model.CrmContact;
import DKSPACE.PhamarERP.crm.service.CrmContactService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
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
