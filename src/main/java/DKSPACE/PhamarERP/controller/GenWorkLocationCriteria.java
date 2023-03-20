package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.master_data.entity.GenWorkLocation;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenWorkLocationCriteria implements Criteria<GenWorkLocation> {
	private StringFilter nameVi;
	private StringFilter nameEn;
	private StringFilter describe;
	private BooleanFilter isActive;
}