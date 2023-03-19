package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.master_data.dto.criteria.ContractTypeCriteria;
import DKSPACE.PhamarERP.master_data.entity.ContractType;
import DKSPACE.PhamarERP.service.ContractTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/contract-types")
@Tag(name = "ContractType", description = "Loại hợp đồng")
public class ContractTypeController extends AbstractBaseCRUDController<ContractType,ContractTypeService, ContractTypeCriteria> {
	protected ContractTypeController(ContractTypeService service) {
		super(service, ContractType.class);
	}
}