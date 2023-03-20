package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmTagCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmTag;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmTag_;
import DKSPACE.PhamarERP.repository.crm.CrmTagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrmTagQueryService extends QueryService<CrmTag> implements FilterService<CrmTagCriteria> {
	private final CrmTagRepository repository;
	
	@Transactional(readOnly = true)
	public Page<CrmTag> findByCriteria(CrmTagCriteria criteria, Pageable page) {
		log.debug("CrmTagQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<CrmTag> specification = this.createSpecification(criteria);
		return repository.findAll(specification, page);
	}
	
	private Specification<CrmTag> createSpecification(CrmTagCriteria criteria) {
		return SpecificationBuilder.<CrmTag>builder()
		                           .and(criteria.getName(),
		                                filter -> this.buildStringSpecification(filter, CrmTag_.name))
		                           .and(criteria.getIsActive(),
		                                filter -> this.buildSpecification(filter, CrmTag_.isActive))
		                           .build();
	}
}