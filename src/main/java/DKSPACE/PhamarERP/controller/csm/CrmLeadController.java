package DKSPACE.PhamarERP.controller.csm;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmLeadCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLead;
import DKSPACE.PhamarERP.service.CrmLeadService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/crm-leads")
@ResponseWrapper
@Tag(name = "CrmLead", description = "Khách hàng tiềm năng")
public class CrmLeadController extends AbstractBaseCRUDController<CrmLead, CrmLeadService, CrmLeadCriteria> {
	protected CrmLeadController(CrmLeadService service) {
		super(service, CrmLead.class);
	}
}
