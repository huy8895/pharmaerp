package DKSPACE.PhamarERP.factory.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.factory.criteria.FactoryLineCriteria;
import DKSPACE.PhamarERP.factory.model.FactoryLine;
import DKSPACE.PhamarERP.factory.service.FactoryLineService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/factory-lines")
@ResponseWrapper
@Tag(name = "FactoryLine", description = "Các API liên quan đến FactoryLine")
public class FactoryLineController
		extends AbstractBaseCRUDController<FactoryLine, FactoryLineService, FactoryLineCriteria> {
	
	protected FactoryLineController(FactoryLineService service) {
		super(service, FactoryLine.class);
	}
}