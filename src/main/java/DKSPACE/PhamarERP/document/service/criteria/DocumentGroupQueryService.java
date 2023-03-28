package DKSPACE.PhamarERP.document.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.document.criteria.DocumentGroupCriteria;
import DKSPACE.PhamarERP.document.model.DocumentGroup;
import DKSPACE.PhamarERP.document.model.DocumentGroup_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentGroupQueryService extends FilterService<DocumentGroup, DocumentGroupCriteria> {
	
	public Specification<DocumentGroup> createSpecification(DocumentGroupCriteria criteria) {
		return SpecificationBuilder
				.<DocumentGroup>builder()
				.and(criteria.getParentId(), DocumentGroup_.parentId, super::buildSpecification)
				.and(criteria.getNameVi(), DocumentGroup_.nameVi, super::buildStringSpecification)
				.and(criteria.getNameEn(), DocumentGroup_.nameEn, super::buildStringSpecification)
				.and(criteria.getIsActive(), DocumentGroup_.isActive, super::buildSpecification)
				.build();
	}
}