package DKSPACE.PhamarERP.document.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.document.criteria.DocumentGroupCriteria;
import DKSPACE.PhamarERP.document.model.DocumentGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentGroupQueryService extends FilterService<DocumentGroup, DocumentGroupCriteria> {
	
	public Specification<DocumentGroup> createSpecification(DocumentGroupCriteria criteria) {
		return SpecificationBuilder
				.<DocumentGroup>builder()
				.build();
	}
}