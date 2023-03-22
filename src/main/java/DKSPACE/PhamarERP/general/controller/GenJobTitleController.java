package DKSPACE.PhamarERP.general.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.general.criteria.GenJobTitleCriteria;
import DKSPACE.PhamarERP.general.model.GenJobTitle;
import DKSPACE.PhamarERP.general.service.GenJobTitleService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/gen-job-titles")
@ResponseWrapper
@Tag(name = "GenJobTitle", description = "Chức danh công việc")
public class GenJobTitleController extends AbstractBaseCRUDController<GenJobTitle, GenJobTitleService, GenJobTitleCriteria> {
	protected GenJobTitleController(GenJobTitleService service) {
		super(service, GenJobTitle.class);
	}
	
}
