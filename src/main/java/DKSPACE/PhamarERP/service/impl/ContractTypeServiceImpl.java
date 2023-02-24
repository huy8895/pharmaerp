package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.entity.ContractType;
import DKSPACE.PhamarERP.repository.ContractTypeRepository;
import DKSPACE.PhamarERP.service.ContractTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContractTypeServiceImpl extends AbstractBaseCRUDService<ContractType, ContractTypeRepository> implements ContractTypeService {
    protected ContractTypeServiceImpl(ContractTypeRepository repository) {
        super(repository);
    }
}
