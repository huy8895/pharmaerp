package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.entity.ActivityLog;
import DKSPACE.PhamarERP.repository.ActivityLogRepository;
import DKSPACE.PhamarERP.service.ActivityLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActivityLogServiceImpl extends AbstractBaseCRUDService<ActivityLog, ActivityLogRepository> implements ActivityLogService {
	protected ActivityLogServiceImpl(ActivityLogRepository repository) {
		super(repository);
	}
}