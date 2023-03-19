package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.ActivityLogCriteria;
import DKSPACE.PhamarERP.master_data.entity.ActivityLog;
import DKSPACE.PhamarERP.repository.ActivityLogRepository;
import DKSPACE.PhamarERP.service.ActivityLogService;
import DKSPACE.PhamarERP.service.criteria.ActivityLogQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
	public Object findByCriteria(Pageable pageable, Criteria<ActivityLog> criteria) {
		if (criteria instanceof ActivityLogCriteria activityLogCriteria) {
			return queryService.findByCriteria(activityLogCriteria, pageable);
		}
		log.error("findByCriteria criteria must be ActivityLogCriteria");
		throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
	}
}