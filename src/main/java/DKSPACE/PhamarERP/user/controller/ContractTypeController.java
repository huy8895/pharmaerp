package DKSPACE.PhamarERP.user.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.user.dto.criteria.ContractTypeCriteria;
import DKSPACE.PhamarERP.user.model.ContractType;
import DKSPACE.PhamarERP.user.service.ContractTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/contract-types")
@ResponseWrapper
@Tag(name = "ContractType", description = "Loại hợp đồng")
public class ContractTypeController extends AbstractBaseCRUDController<ContractType,ContractTypeService, ContractTypeCriteria> {
	protected ContractTypeController(ContractTypeService service) {
		super(service, ContractType.class);
	}
}