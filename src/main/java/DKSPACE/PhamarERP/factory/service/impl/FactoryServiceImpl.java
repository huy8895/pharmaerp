package DKSPACE.PhamarERP.factory.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.factory.model.Factory;
import DKSPACE.PhamarERP.factory.repository.FactoryRepository;
import DKSPACE.PhamarERP.factory.service.FactoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FactoryServiceImpl extends AbstractBaseCRUDService<Factory, FactoryRepository> implements FactoryService {
	protected FactoryServiceImpl(FactoryRepository repository) {
		super(repository);
	}
}