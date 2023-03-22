package DKSPACE.PhamarERP.general.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.general.criteria.GenOfficerLevelCriteria;
import DKSPACE.PhamarERP.general.model.GenOfficerLevel;
import DKSPACE.PhamarERP.general.service.GenOfficerLevelService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/gen-officer-levels")
@ResponseWrapper
@Tag(name = "GenOfficerLevel", description = "Cấp bậc cán bộ")
public class GenOfficerLevelController extends AbstractBaseCRUDController<GenOfficerLevel, GenOfficerLevelService, GenOfficerLevelCriteria> {
	protected GenOfficerLevelController(GenOfficerLevelService service) {
		super(service, GenOfficerLevel.class);
	}
}
