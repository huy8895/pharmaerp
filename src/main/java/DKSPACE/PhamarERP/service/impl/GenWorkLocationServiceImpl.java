package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.entity.GenWorkLocation;
import DKSPACE.PhamarERP.repository.GenWorkLocationRepository;
import DKSPACE.PhamarERP.service.GenWorkLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenWorkLocationServiceImpl extends AbstractBaseCRUDService<GenWorkLocation, GenWorkLocationRepository> implements GenWorkLocationService {
    protected GenWorkLocationServiceImpl(GenWorkLocationRepository repository) {
        super(repository);
    }
}
