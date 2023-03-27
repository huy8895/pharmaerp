package DKSPACE.PhamarERP.factory.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.factory.criteria.FactoryCriteria;
import DKSPACE.PhamarERP.factory.model.Factory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FactoryQueryService extends FilterService<Factory, FactoryCriteria> {
	
	public Specification<Factory> createSpecification(FactoryCriteria criteria) {
		return SpecificationBuilder
				.<Factory>builder()
				.build();
	}
}