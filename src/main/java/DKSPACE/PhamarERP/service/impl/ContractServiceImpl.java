package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.entity.Contract;
import DKSPACE.PhamarERP.repository.ContractRepository;
import DKSPACE.PhamarERP.service.ContractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContractServiceImpl extends AbstractBaseCRUDService<Contract, ContractRepository> implements ContractService {
    protected ContractServiceImpl(ContractRepository repository) {
        super(repository);
    }
}
