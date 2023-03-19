package DKSPACE.PhamarERP.master_data.dto.criteria;


import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.master_data.entity.ActivityLog;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLogCriteria implements Criteria<ActivityLog> {
	private LongFilter userId;
	private StringFilter ip;
	private StringFilter userAgent;
	private StringFilter request;
	private StringFilter response;
}