package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmLeadCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLead;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLead_;
import DKSPACE.PhamarERP.repository.crm.CrmLeadRepository;
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
public class CrmLeadQueryService extends QueryService<CrmLead> implements FilterService<CrmLeadCriteria> {
	private final CrmLeadRepository repository;
	
	@Transactional(readOnly = true)
	public Page<CrmLead> findByCriteria(CrmLeadCriteria criteria, Pageable page) {
		log.debug("CrmLeadQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<CrmLead> specification = this.createSpecification(criteria);
		return repository.findAll(specification, page);
	}
	
	private Specification<CrmLead> createSpecification(CrmLeadCriteria criteria) {
		return SpecificationBuilder
				.<CrmLead>builder()
				.and(criteria.getName(), filter -> this.buildStringSpecification(filter, CrmLead_.name))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, CrmLead_.describe))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter, CrmLead_.isActive))
				.build();
	}
}