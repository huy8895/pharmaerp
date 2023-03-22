package DKSPACE.PhamarERP.user.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.user.dto.criteria.ContractCriteria;
import DKSPACE.PhamarERP.user.model.Contract;
import DKSPACE.PhamarERP.user.repository.ContractRepository;
import DKSPACE.PhamarERP.user.service.ContractService;
import DKSPACE.PhamarERP.user.service.criteria.ContractQueryService;
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