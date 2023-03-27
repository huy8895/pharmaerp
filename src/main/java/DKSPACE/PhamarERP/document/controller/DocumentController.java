package DKSPACE.PhamarERP.document.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.document.criteria.DocumentCriteria;
import DKSPACE.PhamarERP.document.model.Document;
import DKSPACE.PhamarERP.document.service.DocumentService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/documents")
@ResponseWrapper
@Tag(name = "Document", description = "Các API liên quan đến Document")
public class DocumentController
		extends AbstractBaseCRUDController<Document, DocumentService, DocumentCriteria> {
	
	protected DocumentController(DocumentService service) {
		super(service, Document.class);
	}
}