package DKSPACE.PhamarERP.general.criteria;


import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.general.model.ActivityLog;
import DKSPACE.PhamarERP.general.model.ActivityLog_;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.*;

import java.util.List;

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
	
	@Override
	public List<SingularAttribute<ActivityLog, String>> searchBy() {
		return List.of(ActivityLog_.request,
		               ActivityLog_.response,
		               ActivityLog_.userAgent,
		               ActivityLog_.ip);
	}
}