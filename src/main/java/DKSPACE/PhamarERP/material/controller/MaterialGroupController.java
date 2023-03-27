package DKSPACE.PhamarERP.material.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.material.criteria.MaterialGroupCriteria;
import DKSPACE.PhamarERP.material.model.MaterialGroup;
import DKSPACE.PhamarERP.material.service.MaterialGroupService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/material-groups")
@ResponseWrapper
@Tag(name = "MaterialGroup", description = "Các API liên quan đến MaterialGroup")
public class MaterialGroupController
		extends AbstractBaseCRUDController<MaterialGroup, MaterialGroupService, MaterialGroupCriteria> {
	
	protected MaterialGroupController(MaterialGroupService service) {
		super(service, MaterialGroup.class);
	}
}