package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.master_data.entity.ContractType;
import DKSPACE.PhamarERP.service.ContractTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/contract-type")
public class ContractTypeController extends AbstractBaseCRUDController<ContractType, ContractTypeService> {
    protected ContractTypeController(ContractTypeService service) {
        super(service, ContractType.class);
    }
}
