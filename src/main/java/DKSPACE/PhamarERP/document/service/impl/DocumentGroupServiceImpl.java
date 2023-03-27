package DKSPACE.PhamarERP.document.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.document.model.DocumentGroup;
import DKSPACE.PhamarERP.document.repository.DocumentGroupRepository;
import DKSPACE.PhamarERP.document.service.DocumentGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DocumentGroupServiceImpl extends AbstractBaseCRUDService<DocumentGroup, DocumentGroupRepository> implements DocumentGroupService {
	protected DocumentGroupServiceImpl(DocumentGroupRepository repository) {
		super(repository);
	}
}