package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.ContractTypeCriteria;
import DKSPACE.PhamarERP.master_data.entity.ContractType;
import DKSPACE.PhamarERP.repository.ContractTypeRepository;
import DKSPACE.PhamarERP.service.ContractTypeService;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContractTypeServiceImpl extends AbstractBaseCRUDService<ContractType, ContractTypeRepository> implements ContractTypeService {
	private final FilterService<ContractTypeCriteria> queryService;
	
	protected ContractTypeServiceImpl(ContractTypeRepository repository,
	                                  FilterService<ContractTypeCriteria> queryService) {
		super(repository);
		this.queryService = queryService;
	}
	
	@Override
	public Object findByCriteria(Pageable pageable, Criteria<ContractType> criteria) {
		if (criteria instanceof ContractTypeCriteria contractCriteria) {
			return queryService.findByCriteria(contractCriteria, pageable);
		}
		log.error("findByCriteria criteria must be ContractCriteria");
		throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
	}
}