package DKSPACE.PhamarERP.master_data.dto.criteria;


import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLogCriteria implements Serializable {
	private LongFilter userId;
	private StringFilter ip;
	private StringFilter userAgent;
	private StringFilter request;
	private StringFilter response;
}