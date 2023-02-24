package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.entity.GenOfficerLevel;
import DKSPACE.PhamarERP.repository.GenOfficerLevelRepository;
import DKSPACE.PhamarERP.service.GenOfficerLevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenOfficerLevelServiceImpl extends AbstractBaseCRUDService<GenOfficerLevel, GenOfficerLevelRepository> implements GenOfficerLevelService {
    protected GenOfficerLevelServiceImpl(GenOfficerLevelRepository repository) {
        super(repository);
    }
}
