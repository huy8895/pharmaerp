package DKSPACE.PhamarERP.user.dto.criteria;

import DKSPACE.PhamarERP.basecrud.query.BaseCrudCriteria;
import DKSPACE.PhamarERP.user.model.Contract;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractCriteria extends BaseCrudCriteria<Contract> {
	private LongFilter userId;
	private LongFilter creatorId;
	private LongFilter contractTypeId;
	private LongFilter genWorkLocationId;
	private LongFilter genOfficerLevelId;
	private LongFilter genDepartmentId;
	private LongFilter genJobTitleId;
	private StringFilter contractCode;
	private LongFilter duration;
	private LocalDateFilter startDate;
	private LocalDateFilter endDate;
	private StringFilter status;
	private StringFilter note;
}
