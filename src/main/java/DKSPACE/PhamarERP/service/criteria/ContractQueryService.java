package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.auth.model.User_;
import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.ContractCriteria;
import DKSPACE.PhamarERP.master_data.entity.*;
import DKSPACE.PhamarERP.repository.ContractRepository;
import jakarta.persistence.criteria.JoinType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContractQueryService extends QueryService<Contract>
		implements FilterService<ContractCriteria> {
	private final ContractRepository contractRepository;
	
	@Override
	public Object findByCriteria(ContractCriteria criteria, Pageable page) {
		log.debug("ContractQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<Contract> specification = this.createSpecification(criteria);
		return contractRepository.findAll(specification, page);
	}
	
	private Specification<Contract> createSpecification(ContractCriteria criteria) {
		return SpecificationBuilder
				.<Contract>builder()
				.and(criteria.getUserId(), filter -> this.buildSpecification(filter, Contract_.userId))
				.and(criteria.getCreatorId(), filter -> this.buildSpecification(filter,
				                                                                contractRoot -> contractRoot.join(
						                                                                Contract_.creator,
						                                                                JoinType.LEFT).get(
						                                                                User_.id)))
				.and(criteria.getContractTypeId(), filter -> this.buildSpecification(filter,
				                                                                     contractRoot -> contractRoot.join(
						                                                                     Contract_.contractType,
						                                                                     JoinType.LEFT).get(
						                                                                     ContractType_.id)))
				.and(criteria.getGenWorkLocationId(), filter -> this.buildSpecification(filter,
				                                                                        contractRoot -> contractRoot.join(
						                                                                        Contract_.genWorkLocation,
						                                                                        JoinType.LEFT).get(
						                                                                        GenWorkLocation_.id)))
				.and(criteria.getGenOfficerLevelId(), filter -> this.buildSpecification(filter,
				                                                                        contractRoot -> contractRoot.join(
						                                                                        Contract_.genOfficerLevel,
						                                                                        JoinType.LEFT).get(
						                                                                        GenOfficerLevel_.id)))
				.and(criteria.getGenDepartmentId(),
				     filter -> this.buildSpecification(filter, Contract_.genDepartmentId))
				.and(criteria.getGenJobTitleId(), filter -> this.buildSpecification(filter,
				                                                                    contractRoot -> contractRoot.join(
						                                                                                                Contract_.genJobTitle,
						                                                                                                JoinType.LEFT)
				                                                                                                .get(GenJobTitle_.id)))
				.and(criteria.getContractCode(),
				     filter -> this.buildStringSpecification(filter, Contract_.contractCode))
				.and(criteria.getDuration(), filter -> this.buildSpecification(filter, Contract_.duration))
				.and(criteria.getStartDate(), filter -> this.buildRangeSpecification(filter, Contract_.startDate))
				.and(criteria.getEndDate(), filter -> this.buildRangeSpecification(filter, Contract_.endDate))
				.and(criteria.getStatus(), filter -> this.buildStringSpecification(filter, Contract_.status))
				.and(criteria.getNote(), filter -> this.buildStringSpecification(filter, Contract_.note))
				.build();
	}
}
