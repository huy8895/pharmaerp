package DKSPACE.PhamarERP.master_data.sample;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/sample")
public class SampleController extends AbstractBaseCRUDController<SampleEntity, SampleService> {
    protected SampleController(SampleService service) {
        super(service, SampleEntity.class);
    }
}
