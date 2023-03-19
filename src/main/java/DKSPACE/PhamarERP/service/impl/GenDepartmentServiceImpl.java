package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenDepartmentCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenDepartment;
import DKSPACE.PhamarERP.repository.GenDepartmentRepository;
import DKSPACE.PhamarERP.service.GenDepartmentService;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import DKSPACE.PhamarERP.service.criteria.GenDepartmentQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenDepartmentServiceImpl extends AbstractBaseCRUDService<GenDepartment, GenDepartmentRepository> implements GenDepartmentService {
	private final FilterService<GenDepartmentCriteria> queryService;
	
	protected GenDepartmentServiceImpl(GenDepartmentRepository repository,
	                                   GenDepartmentQueryService queryService) {
		super(repository);
		this.queryService = queryService;
	}
	
	@Override
	public Object findByCriteria(Pageable pageable, Criteria<GenDepartment> criteria) {
		if (criteria instanceof GenDepartmentCriteria contractCriteria) {
			return queryService.findByCriteria(contractCriteria, pageable);
		}
		log.error("findByCriteria criteria must be ContractTypeCriteria");
		throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
	}
	
	
}