package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenWorkLocationCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenWorkLocation;
import DKSPACE.PhamarERP.master_data.entity.GenWorkLocation_;
import DKSPACE.PhamarERP.repository.GenWorkLocationRepository;
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
public class GenWorkLocationQueryService extends QueryService<GenWorkLocation> implements FilterService<GenWorkLocationCriteria> {
	private final GenWorkLocationRepository repository;
	
	@Transactional(readOnly = true)
	public Page<GenWorkLocation> findByCriteria(GenWorkLocationCriteria criteria, Pageable page) {
		log.debug("GenWorkLocationQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<GenWorkLocation> specification = this.createSpecification(criteria);
		return repository.findAll(specification, page);
	}
	
	private Specification<GenWorkLocation> createSpecification(GenWorkLocationCriteria criteria) {
		return SpecificationBuilder
				.<GenWorkLocation>builder()
				.and(criteria.getNameVi(), filter -> this.buildStringSpecification(filter, GenWorkLocation_.nameVi))
				.and(criteria.getNameEn(), filter -> this.buildStringSpecification(filter, GenWorkLocation_.nameEn))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, GenWorkLocation_.describe))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter, GenWorkLocation_.isActive))
				.build();
	}
}