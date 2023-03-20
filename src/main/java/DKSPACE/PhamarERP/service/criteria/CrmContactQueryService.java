package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmContactCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmContact;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmContact_;
import DKSPACE.PhamarERP.repository.crm.CrmContactRepository;
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
public class CrmContactQueryService extends QueryService<CrmContact> implements FilterService<CrmContactCriteria> {
	private final CrmContactRepository repository;
	
	@Transactional(readOnly = true)
	public Page<CrmContact> findByCriteria(CrmContactCriteria criteria, Pageable page) {
		log.debug("CrmContactQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<CrmContact> specification = this.createSpecification(criteria);
		return repository.findAll(specification, page);
	}
	
	private Specification<CrmContact> createSpecification(CrmContactCriteria criteria) {
		return SpecificationBuilder
				.<CrmContact>builder()
				.and(criteria.getCrmCompanyId(), filter -> this.buildSpecification(filter, CrmContact_.id))
				.and(criteria.getEmail(), filter -> this.buildStringSpecification(filter, CrmContact_.email))
				.and(criteria.getTel(), filter -> this.buildStringSpecification(filter, CrmContact_.tel))
				.and(criteria.getFirstName(), filter -> this.buildStringSpecification(filter, CrmContact_.firstName))
				.and(criteria.getLastName(), filter -> this.buildStringSpecification(filter, CrmContact_.lastName))
				.and(criteria.getEnglishName(), filter -> this.buildStringSpecification(filter, CrmContact_.englishName))
				.and(criteria.getDesignation(), filter -> this.buildStringSpecification(filter,CrmContact_.designation))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter,CrmContact_.isActive))
				.build();
	}
}