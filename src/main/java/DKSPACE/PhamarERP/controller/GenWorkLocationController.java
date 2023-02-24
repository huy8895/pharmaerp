package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.master_data.entity.GenWorkLocation;
import DKSPACE.PhamarERP.service.GenWorkLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/gen-work-location")
public class GenWorkLocationController extends AbstractBaseCRUDController<GenWorkLocation, GenWorkLocationService> {
    protected GenWorkLocationController(GenWorkLocationService service) {
        super(service, GenWorkLocation.class);
    }
}
