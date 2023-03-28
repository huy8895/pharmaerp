package DKSPACE.PhamarERP.material.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.material.model.GenUnit;
import DKSPACE.PhamarERP.material.repository.GenUnitRepository;
import DKSPACE.PhamarERP.material.service.GenUnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenUnitServiceImpl extends AbstractBaseCRUDService<GenUnit, GenUnitRepository> implements GenUnitService {
	protected GenUnitServiceImpl(GenUnitRepository repository) {
		super(repository);
	}
}