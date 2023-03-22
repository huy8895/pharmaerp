package DKSPACE.PhamarERP.general.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.general.criteria.GenWorkLocationCriteria;
import DKSPACE.PhamarERP.general.model.GenWorkLocation;
import DKSPACE.PhamarERP.general.service.GenWorkLocationService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/gen-work-locations")
@ResponseWrapper
@Tag(name = "GenWorkLocation", description = "Địa điểm làm việc")
public class GenWorkLocationController extends AbstractBaseCRUDController<GenWorkLocation, GenWorkLocationService, GenWorkLocationCriteria> {
	protected GenWorkLocationController(GenWorkLocationService service) {
		super(service, GenWorkLocation.class);
	}
}
