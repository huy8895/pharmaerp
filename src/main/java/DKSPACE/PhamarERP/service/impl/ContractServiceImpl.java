package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.ContractCriteria;
import DKSPACE.PhamarERP.master_data.entity.Contract;
import DKSPACE.PhamarERP.repository.ContractRepository;
import DKSPACE.PhamarERP.service.ContractService;
import DKSPACE.PhamarERP.service.criteria.ContractQueryService;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContractServiceImpl extends AbstractBaseCRUDService<Contract, ContractRepository> implements ContractService {
	private final FilterService<Contract,ContractCriteria> queryService;
	
	protected ContractServiceImpl(ContractRepository repository, ContractQueryService queryService) {
		super(repository);
		this.queryService = queryService;
	}
	
	@Override
	public Object findByCriteria(Pageable pageable, Criteria<Contract> criteria) {
		if (criteria instanceof ContractCriteria contractCriteria) {
			return queryService.findByCriteria(contractCriteria, pageable, repository::findAll);
		}
		log.error("findByCriteria criteria must be ContractCriteria");
		throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
	}
}