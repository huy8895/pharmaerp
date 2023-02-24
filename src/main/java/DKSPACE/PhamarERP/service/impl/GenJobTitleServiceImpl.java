package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.entity.GenJobTitle;
import DKSPACE.PhamarERP.repository.GenJobTitleRepository;
import DKSPACE.PhamarERP.service.GenJobTitleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenJobTitleServiceImpl extends AbstractBaseCRUDService<GenJobTitle, GenJobTitleRepository> implements GenJobTitleService {
    protected GenJobTitleServiceImpl(GenJobTitleRepository repository) {
        super(repository);
    }
}
