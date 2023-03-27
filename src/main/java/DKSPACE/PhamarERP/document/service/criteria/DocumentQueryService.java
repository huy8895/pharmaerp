package DKSPACE.PhamarERP.document.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.document.criteria.DocumentCriteria;
import DKSPACE.PhamarERP.document.model.Document;
import DKSPACE.PhamarERP.document.model.Document_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentQueryService extends FilterService<Document, DocumentCriteria> {
	
	public Specification<Document> createSpecification(DocumentCriteria criteria) {
		return SpecificationBuilder
				.<Document>builder()
				.and(criteria.getDocumentGroupId(), Document_.documentGroupId, super::buildSpecification)
				.and(criteria.getNameVi(), Document_.nameVi, super::buildStringSpecification)
				.and(criteria.getNameEn(), Document_.nameEn, super::buildStringSpecification)
				.and(criteria.getDescribe(), Document_.describe, super::buildStringSpecification)
				.and(criteria.getIsActive(), Document_.isActive, super::buildSpecification)
				.build();
	}
}