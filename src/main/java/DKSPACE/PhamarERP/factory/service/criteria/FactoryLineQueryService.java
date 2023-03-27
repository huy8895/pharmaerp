package DKSPACE.PhamarERP.factory.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.factory.criteria.FactoryLineCriteria;
import DKSPACE.PhamarERP.factory.model.FactoryLine;
import DKSPACE.PhamarERP.factory.model.FactoryLine_;
import DKSPACE.PhamarERP.factory.model.Factory_;
import jakarta.persistence.criteria.JoinType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FactoryLineQueryService extends FilterService<FactoryLine, FactoryLineCriteria> {
	
	public Specification<FactoryLine> createSpecification(FactoryLineCriteria criteria) {
		return SpecificationBuilder.<FactoryLine>builder()
		                           .and(criteria.getFactoryId(),
		                                root -> root.join(FactoryLine_.factory, JoinType.LEFT).get(Factory_.id),
		                                super::buildRangeSpecification)
		                           .and(criteria.getNameVi(), FactoryLine_.nameVi, super::buildStringSpecification)
		                           .and(criteria.getNameEn(), FactoryLine_.nameEn, super::buildStringSpecification)
		                           .and(criteria.getFactoryLineCode(), FactoryLine_.factoryLineCode,
		                                super::buildStringSpecification)
		                           .and(criteria.getDescribe(), FactoryLine_.describe, super::buildStringSpecification)
		                           .and(criteria.getIsActive(), FactoryLine_.isActive, super::buildSpecification)
		                           .build();
	}
}