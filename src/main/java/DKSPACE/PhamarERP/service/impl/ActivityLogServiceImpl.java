package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.dto.criteria.ActivityLogCriteria;
import DKSPACE.PhamarERP.master_data.entity.ActivityLog;
import DKSPACE.PhamarERP.repository.ActivityLogRepository;
import DKSPACE.PhamarERP.service.ActivityLogService;
import DKSPACE.PhamarERP.service.criteria.ActivityLogQueryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Slf4j
public class ActivityLogServiceImpl extends AbstractBaseCRUDService<ActivityLog, ActivityLogRepository> implements ActivityLogService {
	private final ActivityLogQueryService queryService;
	protected ActivityLogServiceImpl(ActivityLogRepository repository,
	                                 ActivityLogQueryService queryService) {
		super(repository);
		this.queryService = queryService;
	}

	
	
	@Override
	public Object getList(Pageable pageable, ActivityLogCriteria criteria) {
		return queryService.findByCriteria(criteria, pageable);
	}
}