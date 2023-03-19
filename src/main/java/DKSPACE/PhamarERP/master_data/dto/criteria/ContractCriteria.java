package DKSPACE.PhamarERP.master_data.dto.criteria;

import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.master_data.entity.Contract;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractCriteria implements Criteria<Contract> {
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
