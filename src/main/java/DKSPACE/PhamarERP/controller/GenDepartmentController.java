package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenDepartmentCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenDepartment;
import DKSPACE.PhamarERP.service.GenDepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/gen-departments")
@ResponseWrapper
@Tag(name = "GenDepartment", description = "Các API liên quan đến GenDepartment")
public class GenDepartmentController
		extends AbstractBaseCRUDController<GenDepartment, GenDepartmentService, GenDepartmentCriteria> {
	
	protected GenDepartmentController(GenDepartmentService service) {
		super(service, GenDepartment.class);
	}
}