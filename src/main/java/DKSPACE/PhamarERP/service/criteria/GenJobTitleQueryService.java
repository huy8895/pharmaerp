package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenJobTitleCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenJobTitle;
import DKSPACE.PhamarERP.master_data.entity.GenJobTitle_;
import DKSPACE.PhamarERP.repository.GenJobTitleRepository;
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
public class GenJobTitleQueryService extends QueryService<GenJobTitle> implements FilterService<GenJobTitleCriteria> {
	private final GenJobTitleRepository genJobTitleRepository;
	
	@Transactional(readOnly = true)
	public Page<GenJobTitle> findByCriteria(GenJobTitleCriteria criteria, Pageable page) {
		log.debug("GenJobTitleQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<GenJobTitle> specification = this.createSpecification(criteria);
		return genJobTitleRepository.findAll(specification, page);
	}
	
	private Specification<GenJobTitle> createSpecification(GenJobTitleCriteria criteria) {
		return SpecificationBuilder
				.<GenJobTitle>builder()
				.and(criteria.getNameVi(), filter -> this.buildStringSpecification(filter, GenJobTitle_.nameVi))
				.and(criteria.getNameEn(), filter -> this.buildStringSpecification(filter, GenJobTitle_.nameEn))
				.and(criteria.getSalary(), filter -> this.buildSpecification(filter, GenJobTitle_.salary))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, GenJobTitle_.describe))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter, GenJobTitle_.isActive))
				.build();
	}
}
