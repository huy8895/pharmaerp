package DKSPACE.PhamarERP.material.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.material.criteria.GenUnitCriteria;
import DKSPACE.PhamarERP.material.model.GenUnit;
import DKSPACE.PhamarERP.material.service.GenUnitService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/gen-units")
@ResponseWrapper
@Tag(name = "GenUnit", description = "Các API liên quan đến GenUnit")
public class GenUnitController
		extends AbstractBaseCRUDController<GenUnit, GenUnitService, GenUnitCriteria> {
	
	protected GenUnitController(GenUnitService service) {
		super(service, GenUnit.class);
	}
}