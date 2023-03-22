package DKSPACE.PhamarERP.user.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.user.dto.criteria.ContractTypeCriteria;
import DKSPACE.PhamarERP.user.model.ContractType;
import DKSPACE.PhamarERP.user.repository.ContractTypeRepository;
import DKSPACE.PhamarERP.user.service.ContractTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContractTypeServiceImpl extends AbstractBaseCRUDService<ContractType, ContractTypeRepository> implements ContractTypeService {
	private final FilterService<ContractType,ContractTypeCriteria> queryService;
	
	protected ContractTypeServiceImpl(ContractTypeRepository repository,
	                                  FilterService<ContractType,ContractTypeCriteria> queryService) {
		super(repository);
		this.queryService = queryService;
	}
	
	@Override
	public Object findByCriteria(Pageable pageable, Criteria<ContractType> criteria) {
		if (criteria instanceof ContractTypeCriteria contractCriteria) {
			return queryService.findByCriteria(contractCriteria, pageable, repository::findAll);
		}
		log.error("findByCriteria criteria must be ContractTypeCriteria");
		throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
	}
}