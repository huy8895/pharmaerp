package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenOfficerLevelCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenOfficerLevel;
import DKSPACE.PhamarERP.master_data.entity.GenOfficerLevel_;
import DKSPACE.PhamarERP.repository.GenOfficerLevelRepository;
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
public class GenOfficerLevelQueryService extends QueryService<GenOfficerLevel> implements FilterService<GenOfficerLevelCriteria> {
	private final GenOfficerLevelRepository genOfficerLevelRepository;
	
	@Transactional(readOnly = true)
	public Page<GenOfficerLevel> findByCriteria(GenOfficerLevelCriteria criteria, Pageable page) {
		log.debug("GenOfficerLevelQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<GenOfficerLevel> specification = this.createSpecification(criteria);
		return genOfficerLevelRepository.findAll(specification, page);
	}
	
	private Specification<GenOfficerLevel> createSpecification(GenOfficerLevelCriteria criteria) {
		return SpecificationBuilder
				.<GenOfficerLevel>builder()
				.and(criteria.getNameVi(), filter -> this.buildStringSpecification(filter, GenOfficerLevel_.nameVi))
				.and(criteria.getNameEn(), filter -> this.buildStringSpecification(filter, GenOfficerLevel_.nameEn))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, GenOfficerLevel_.describe))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter, GenOfficerLevel_.isActive))
				.build();
	}
}
