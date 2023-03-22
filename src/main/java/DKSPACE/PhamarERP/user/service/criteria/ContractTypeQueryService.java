package DKSPACE.PhamarERP.user.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.QueryService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.user.dto.criteria.ContractTypeCriteria;
import DKSPACE.PhamarERP.user.model.ContractType;
import DKSPACE.PhamarERP.user.model.ContractType_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContractTypeQueryService extends QueryService<ContractType>
		implements FilterService<ContractType,ContractTypeCriteria> {
	
	public Specification<ContractType> createSpecification(ContractTypeCriteria criteria) {
		return SpecificationBuilder
				.<ContractType>builder()
				.and(criteria.getNameVi(), ContractType_.nameVi, super::buildStringSpecification)
				.and(criteria.getNameEn(), ContractType_.nameEn, super::buildStringSpecification)
				.and(criteria.getIsDetermineDeadline(), ContractType_.isDetermineDeadline, super::buildSpecification)
				.and(criteria.getIsActive(), ContractType_.isActive, super::buildSpecification)
				.and(criteria.getDescribe(), ContractType_.describe, super::buildStringSpecification)
				.build();
	}
}
