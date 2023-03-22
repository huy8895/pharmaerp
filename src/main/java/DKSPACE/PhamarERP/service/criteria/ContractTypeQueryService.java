package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.ContractTypeCriteria;
import DKSPACE.PhamarERP.master_data.entity.ContractType;
import DKSPACE.PhamarERP.master_data.entity.ContractType_;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContractTypeQueryService extends QueryService<ContractType>
		implements FilterService<ContractTypeCriteria> {

	
	public Specification<ContractType> createSpecification(ContractTypeCriteria criteria) {
		return SpecificationBuilder
				.<ContractType>builder()
				.and(criteria.getNameVi(), filter -> this.buildStringSpecification(filter, ContractType_.nameVi))
				.and(criteria.getNameEn(), filter -> this.buildStringSpecification(filter, ContractType_.nameEn))
				.and(criteria.getIsDetermineDeadline(), filter -> this.buildSpecification(filter, ContractType_.isDetermineDeadline))
				.and(criteria.getIsActive(), filter -> this.buildSpecification(filter, ContractType_.isActive))
				.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, ContractType_.describe))
				.build();
	}
	
	@Override
	public Specification<ContractTypeCriteria> createSpecification(Criteria criteria) {
		return null;
	}
}
