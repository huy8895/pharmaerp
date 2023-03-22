package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.auth.model.User_;
import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.ContractCriteria;
import DKSPACE.PhamarERP.master_data.entity.*;
import jakarta.persistence.criteria.JoinType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContractQueryService extends QueryService<Contract>
		implements FilterService<Contract, ContractCriteria> {
	
	public Specification<Contract> createSpecification(ContractCriteria criteria) {
		return SpecificationBuilder
				.<Contract>builder()
				.and(criteria.getUserId(),Contract_.userId, super::buildSpecification)
				.and(criteria.getCreatorId(), root -> root.join(Contract_.creator, JoinType.LEFT).get(User_.id),
				     super::buildRangeSpecification)
				.and(criteria.getContractTypeId(), root -> root.join(Contract_.contractType, JoinType.LEFT).get(ContractType_.id),
				     super::buildRangeSpecification)
				.and(criteria.getGenWorkLocationId(), root -> root.join(Contract_.genWorkLocation, JoinType.LEFT).get(GenWorkLocation_.id),
				     super::buildRangeSpecification)
				.and(criteria.getGenOfficerLevelId(), root -> root.join(Contract_.genOfficerLevel, JoinType.LEFT).get(GenOfficerLevel_.id),
				     super::buildRangeSpecification)
				.and(criteria.getGenJobTitleId(), root -> root.join(Contract_.genJobTitle, JoinType.LEFT).get(GenJobTitle_.id),
				     super::buildRangeSpecification)
				.and(criteria.getGenDepartmentId(), Contract_.genDepartmentId, super::buildSpecification)
				.and(criteria.getContractCode(), Contract_.contractCode, super::buildStringSpecification)
				.and(criteria.getDuration(), Contract_.duration, super::buildSpecification)
				.and(criteria.getStartDate(), Contract_.startDate, super::buildRangeSpecification)
				.and(criteria.getEndDate(), Contract_.endDate, super::buildRangeSpecification)
				.and(criteria.getStatus(), Contract_.status, super::buildStringSpecification)
				.and(criteria.getNote(), Contract_.note, super::buildStringSpecification)
				.build();
	}
	
}
