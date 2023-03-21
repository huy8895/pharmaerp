package DKSPACE.PhamarERP.controller.csm;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmLeadItemCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLeadItem;
import DKSPACE.PhamarERP.service.CrmLeadItemService;
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
