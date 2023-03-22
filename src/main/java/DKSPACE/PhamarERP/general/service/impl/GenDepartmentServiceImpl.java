package DKSPACE.PhamarERP.general.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.general.criteria.GenDepartmentCriteria;
import DKSPACE.PhamarERP.general.model.GenDepartment;
import DKSPACE.PhamarERP.general.repository.GenDepartmentRepository;
import DKSPACE.PhamarERP.general.service.GenDepartmentService;
import DKSPACE.PhamarERP.general.service.criteria.GenDepartmentQueryService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenDepartmentServiceImpl extends AbstractBaseCRUDService<GenDepartment, GenDepartmentRepository> implements GenDepartmentService {
	private final FilterService<GenDepartment,GenDepartmentCriteria> queryService;
	
	protected GenDepartmentServiceImpl(GenDepartmentRepository repository,
	                                   GenDepartmentQueryService queryService) {
		super(repository);
		this.queryService = queryService;
	}
	
	@Override
	public Object findByCriteria(Pageable pageable, Criteria<GenDepartment> criteria) {
		if (criteria instanceof GenDepartmentCriteria contractCriteria) {
			return queryService.findByCriteria(contractCriteria, pageable, repository::findAll);
		}
		log.error("findByCriteria criteria must be ContractTypeCriteria");
		throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
	}
	
	
}