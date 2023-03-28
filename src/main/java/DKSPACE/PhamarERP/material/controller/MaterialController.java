package DKSPACE.PhamarERP.material.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.material.criteria.MaterialCriteria;
import DKSPACE.PhamarERP.material.model.Material;
import DKSPACE.PhamarERP.material.service.MaterialService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/materials")
@ResponseWrapper
@Tag(name = "Material", description = "Các API liên quan đến Material")
public class MaterialController
		extends AbstractBaseCRUDController<Material, MaterialService, MaterialCriteria> {
	
	protected MaterialController(MaterialService service) {
		super(service, Material.class);
	}
}