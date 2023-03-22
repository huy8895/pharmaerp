package DKSPACE.PhamarERP.general.criteria;


import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.general.model.ActivityLog;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLogCriteria extends BaseCrudCriteria<ActivityLog> {
	private LongFilter userId;
	private StringFilter ip;
	private StringFilter userAgent;
	private StringFilter request;
	private StringFilter response;
}