package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.master_data.entity.GenOfficerLevel;
import DKSPACE.PhamarERP.service.GenOfficerLevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/gen-officer-level")
public class GenOfficerLevelController extends AbstractBaseCRUDController<GenOfficerLevel, GenOfficerLevelService> {
    protected GenOfficerLevelController(GenOfficerLevelService service) {
        super(service, GenOfficerLevel.class);
    }
}
