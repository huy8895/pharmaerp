package DKSPACE.PhamarERP.document.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.document.criteria.DocumentCriteria;
import DKSPACE.PhamarERP.document.model.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentQueryService extends FilterService<Document, DocumentCriteria> {
	
	public Specification<Document> createSpecification(DocumentCriteria criteria) {
		return SpecificationBuilder
				.<Document>builder()
				.build();
	}
}