package DKSPACE.PhamarERP.document.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.document.criteria.DocumentGroupCriteria;
import DKSPACE.PhamarERP.document.model.DocumentGroup;
import DKSPACE.PhamarERP.document.service.DocumentGroupService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/documentgroups")
@ResponseWrapper
@Tag(name = "DocumentGroup", description = "Các API liên quan đến DocumentGroup")
public class DocumentGroupController
		extends AbstractBaseCRUDController<DocumentGroup, DocumentGroupService, DocumentGroupCriteria> {
	
	protected DocumentGroupController(DocumentGroupService service) {
		super(service, DocumentGroup.class);
	}
}