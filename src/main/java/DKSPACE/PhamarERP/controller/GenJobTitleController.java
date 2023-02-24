package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.master_data.entity.GenJobTitle;
import DKSPACE.PhamarERP.service.GenJobTitleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/gen-job-title")
public class GenJobTitleController extends AbstractBaseCRUDController<GenJobTitle, GenJobTitleService> {
    protected GenJobTitleController(GenJobTitleService service) {
        super(service, GenJobTitle.class);
    }
}
