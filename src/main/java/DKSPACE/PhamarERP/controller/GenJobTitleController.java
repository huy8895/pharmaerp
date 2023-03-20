package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenJobTitleCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenJobTitle;
import DKSPACE.PhamarERP.service.GenJobTitleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/gen-job-titles")
@ResponseWrapper(excludes = {"exportTemplate","exportFileExcel"})
@Tag(name = "GenJobTitle", description = "Các API liên quan đến GenJobTitle")
public class GenJobTitleController extends AbstractBaseCRUDController<GenJobTitle, GenJobTitleService, GenJobTitleCriteria> {
	protected GenJobTitleController(GenJobTitleService service) {
		super(service, GenJobTitle.class);
	}
	
}
