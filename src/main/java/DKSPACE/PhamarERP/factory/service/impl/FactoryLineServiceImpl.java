package DKSPACE.PhamarERP.factory.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.factory.model.FactoryLine;
import DKSPACE.PhamarERP.factory.repository.FactoryLineRepository;
import DKSPACE.PhamarERP.factory.service.FactoryLineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FactoryLineServiceImpl extends AbstractBaseCRUDService<FactoryLine, FactoryLineRepository> implements FactoryLineService {
	protected FactoryLineServiceImpl(FactoryLineRepository repository) {
		super(repository);
	}
}