package DKSPACE.PhamarERP.document.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.document.model.Document;
import DKSPACE.PhamarERP.document.repository.DocumentRepository;
import DKSPACE.PhamarERP.document.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DocumentServiceImpl extends AbstractBaseCRUDService<Document, DocumentRepository> implements DocumentService {
	protected DocumentServiceImpl(DocumentRepository repository) {
		super(repository);
	}
}