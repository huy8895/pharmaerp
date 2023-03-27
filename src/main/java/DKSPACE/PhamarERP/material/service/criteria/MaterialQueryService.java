package DKSPACE.PhamarERP.material.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.material.criteria.MaterialCriteria;
import DKSPACE.PhamarERP.material.model.Material;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MaterialQueryService extends FilterService<Material, MaterialCriteria> {
	
	public Specification<Material> createSpecification(MaterialCriteria criteria) {
		return SpecificationBuilder
				.<Material>builder()
				.build();
	}
}