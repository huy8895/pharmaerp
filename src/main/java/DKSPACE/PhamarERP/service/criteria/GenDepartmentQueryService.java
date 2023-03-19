package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenDepartmentCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenDepartment;
import DKSPACE.PhamarERP.master_data.entity.GenDepartment_;
import DKSPACE.PhamarERP.repository.GenDepartmentRepository;
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
public class GenDepartmentQueryService extends QueryService<GenDepartment> implements FilterService<GenDepartmentCriteria> {
	private final GenDepartmentRepository genDepartmentRepository;
	
	@Transactional(readOnly = true)
	public Page<GenDepartment> findByCriteria(GenDepartmentCriteria criteria, Pageable page) {
		log.debug("GenDepartmentQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<GenDepartment> specification = this.createSpecification(criteria);
		return genDepartmentRepository.findAll(specification, page);
	}
	
	private Specification<GenDepartment> createSpecification(GenDepartmentCriteria criteria) {
		return SpecificationBuilder
				.<GenDepartment>builder()
				.and(criteria.getNameVi(), filter -> this.buildStringSpecification(filter, GenDepartment_.nameVi))
				.and(criteria.getNameEn(), filter -> this.buildStringSpecification(filter, GenDepartment_.nameEn))
				.and(criteria.getDescribe(),
				     filter -> this.buildStringSpecification(filter, GenDepartment_.describe))
				.and(criteria.getIsActive(),
				     filter -> this.buildSpecification(filter, GenDepartment_.isActive))
				.build();
	}
}
