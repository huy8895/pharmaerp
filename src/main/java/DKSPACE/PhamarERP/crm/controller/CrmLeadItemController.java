package DKSPACE.PhamarERP.crm.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.crm.criteria.CrmLeadItemCriteria;
import DKSPACE.PhamarERP.crm.model.CrmLeadItem;
import DKSPACE.PhamarERP.crm.service.CrmLeadItemService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/crm-lead-items")
@ResponseWrapper
@Tag(name = "CrmLeadItem", description = "Sản phẩm của một khách hàng tiềm năng")
public class CrmLeadItemController extends AbstractBaseCRUDController<CrmLeadItem, CrmLeadItemService, CrmLeadItemCriteria> {
	protected CrmLeadItemController(CrmLeadItemService service) {
		super(service, CrmLeadItem.class);
	}
}
