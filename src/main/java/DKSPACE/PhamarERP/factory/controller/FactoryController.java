package DKSPACE.PhamarERP.factory.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.factory.criteria.FactoryCriteria;
import DKSPACE.PhamarERP.factory.model.Factory;
import DKSPACE.PhamarERP.factory.service.FactoryService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/factories")
@ResponseWrapper
@Tag(name = "Factory", description = "Các API liên quan đến Factory")
public class FactoryController
		extends AbstractBaseCRUDController<Factory, FactoryService, FactoryCriteria> {
	
	protected FactoryController(FactoryService service) {
		super(service, Factory.class);
	}
}