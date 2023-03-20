package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.entity.GenWorkLocation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/genworklocation")
@ResponseWrapper(excludes = {"exportTemplate", "exportFileExcel"})
@Tag(name = "GenWorkLocation", description = "Các API liên quan đến GenWorkLocation")
public class GenWorkLocationController extends AbstractBaseCRUDController<GenWorkLocation, GenWorkLocationService, GenWorkLocationCriteria> {
	protected GenWorkLocationController(GenWorkLocationService service) {
		super(service, GenWorkLocation.class);
	}
}
