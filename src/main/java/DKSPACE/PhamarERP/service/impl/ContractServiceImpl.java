package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.ContractCriteria;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserActivityCriteria;
import DKSPACE.PhamarERP.master_data.entity.Contract;
import DKSPACE.PhamarERP.master_data.entity.UserActivity;
import DKSPACE.PhamarERP.master_data.entity.UserActivity_;
import DKSPACE.PhamarERP.repository.ContractRepository;
import DKSPACE.PhamarERP.repository.UserActivityRepository;
import DKSPACE.PhamarERP.service.ContractService;
import DKSPACE.PhamarERP.service.criteria.ContractQueryService;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ContractServiceImpl extends AbstractBaseCRUDService<Contract, ContractRepository> implements ContractService {
	private final FilterService<ContractCriteria> queryService;
	
	protected ContractServiceImpl(ContractRepository repository, ContractQueryService queryService) {
		super(repository);
		this.queryService = queryService;
	}
	
	@Override
	public Object findByCriteria(Pageable pageable, Criteria<Contract> criteria) {
		if (criteria instanceof ContractCriteria contractCriteria) {
			return queryService.findByCriteria(contractCriteria, pageable);
		}
		log.error("findByCriteria criteria must be ContractCriteria");
		throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
	}
	
	@Slf4j
	@Service
	@RequiredArgsConstructor
	public static class UserActivityQueryService extends QueryService<UserActivity> implements FilterService<UserActivityCriteria> {
		private final UserActivityRepository repository;
		
		@Transactional(readOnly = true)
		public Page<UserActivity> findByCriteria(UserActivityCriteria criteria, Pageable page) {
			log.debug("UserActivityQueryService find by criteria : {}, page: {}", criteria, page);
			final Specification<UserActivity> specification = this.createSpecification(criteria);
			return repository.findAll(specification, page);
		}
		
		private Specification<UserActivity> createSpecification(UserActivityCriteria criteria) {
			return SpecificationBuilder
					.<UserActivity>builder()
					.and(criteria.getUserId(), filter -> this.buildSpecification(filter, UserActivity_.userId))
					.and(criteria.getOrganization(), filter -> this.buildStringSpecification(filter, UserActivity_.organization))
					.and(criteria.getParticipatingPosition(), filter -> this.buildStringSpecification(filter, UserActivity_.participatingPosition))
					.and(criteria.getIsCurrentActive(), filter -> this.buildSpecification(filter, UserActivity_.isCurrentActive))
					.and(criteria.getStartDate(), filter -> this.buildStringSpecification(filter, UserActivity_.startDate))
					.and(criteria.getEndDate(), filter -> this.buildStringSpecification(filter, UserActivity_.endDate))
					.and(criteria.getDescribe(), filter -> this.buildStringSpecification(filter, UserActivity_.describe))
					.and(criteria.getLink(), filter -> this.buildStringSpecification(filter, UserActivity_.link))
					.build();
		}
	}
}