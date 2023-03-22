package DKSPACE.PhamarERP.general.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.general.criteria.GenDepartmentCriteria;
import DKSPACE.PhamarERP.general.model.GenDepartment;
import DKSPACE.PhamarERP.general.service.GenDepartmentService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/gen-departments")
@ResponseWrapper
@Tag(name = "GenDepartment", description = "Phòng ban")
public class GenDepartmentController
		extends AbstractBaseCRUDController<GenDepartment, GenDepartmentService, GenDepartmentCriteria> {
	
	protected GenDepartmentController(GenDepartmentService service) {
		super(service, GenDepartment.class);
	}
}