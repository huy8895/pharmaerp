package DKSPACE.PhamarERP.user.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.user.dto.criteria.ContractCriteria;
import DKSPACE.PhamarERP.user.model.Contract;
import DKSPACE.PhamarERP.user.service.ContractService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/contracts")
@ResponseWrapper
@Tag(name = "Contract", description = "Hợp đồng của người dùng")
public class ContractController extends AbstractBaseCRUDController<Contract, ContractService, ContractCriteria> {
	
	protected ContractController(ContractService service) {
		super(service, Contract.class);
	}
}