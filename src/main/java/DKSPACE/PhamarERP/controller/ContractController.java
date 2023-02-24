package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.master_data.entity.Contract;
import DKSPACE.PhamarERP.service.ContractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/contract")
public class ContractController extends AbstractBaseCRUDController<Contract, ContractService> {
    protected ContractController(ContractService service) {
        super(service, Contract.class);
    }
}
