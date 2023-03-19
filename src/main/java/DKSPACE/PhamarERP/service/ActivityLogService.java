package DKSPACE.PhamarERP.service;

import DKSPACE.PhamarERP.basecrud.BaseCRUDService;
import DKSPACE.PhamarERP.master_data.dto.criteria.ActivityLogCriteria;
import DKSPACE.PhamarERP.master_data.entity.ActivityLog;
import org.springframework.data.domain.Pageable;

public interface ActivityLogService extends BaseCRUDService<ActivityLog> {
	Object getList(Pageable pageable,ActivityLogCriteria criteria);
}