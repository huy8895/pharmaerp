package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.master_data.dto.criteria.ContractCriteria;
import DKSPACE.PhamarERP.master_data.entity.Contract;
import DKSPACE.PhamarERP.service.ContractService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/contracts")
@Tag(name = "Contract", description = "Hợp đồng của người dùng")
public class ContractController extends AbstractBaseCRUDController<Contract, ContractService, ContractCriteria> {
	
	protected ContractController(ContractService service) {
		super(service, Contract.class);
	}
}