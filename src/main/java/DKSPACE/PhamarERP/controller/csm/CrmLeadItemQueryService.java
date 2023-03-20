package DKSPACE.PhamarERP.controller.csm;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLeadItem;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLeadItem_;
import DKSPACE.PhamarERP.repository.crm.CrmLeadItemRepository;
import DKSPACE.PhamarERP.service.criteria.FilterService;
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
public class CrmLeadItemQueryService extends QueryService<CrmLeadItem> implements FilterService<CrmLeadItemCriteria> {
	private final CrmLeadItemRepository repository;
	
	@Transactional(readOnly = true)
	public Page<CrmLeadItem> findByCriteria(CrmLeadItemCriteria criteria, Pageable page) {
		log.debug("CrmLeadItemQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<CrmLeadItem> specification = this.createSpecification(criteria);
		return repository.findAll(specification, page);
	}
	
	private Specification<CrmLeadItem> createSpecification(CrmLeadItemCriteria criteria) {
		return SpecificationBuilder
				.<CrmLeadItem>builder()
				.and(criteria.getCrmLeadId(), filter -> this.buildSpecification(filter, CrmLeadItem_.crmLeadId))
				.and(criteria.getName(), filter -> this.buildStringSpecification(filter, CrmLeadItem_.name))
				.and(criteria.getColor(), filter -> this.buildStringSpecification(filter, CrmLeadItem_.color))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter,CrmLeadItem_.describe))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter,CrmLeadItem_.isActive))
				.build();
	}
}