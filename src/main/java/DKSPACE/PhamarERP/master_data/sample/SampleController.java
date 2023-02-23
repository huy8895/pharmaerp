package DKSPACE.PhamarERP.master_data.sample;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.helper.excel.ExcelHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/sample")
public class SampleController extends AbstractBaseCRUDController<SampleEntity, SampleService> {
    private final ExcelHelper excelHelper;

    protected SampleController(SampleService service, ExcelHelper excelHelper) {
        super(service);
        this.excelHelper = excelHelper;
    }

    @GetMapping("/export-template")
    public ResponseEntity<?> exportTemplate() {
        return ResponseEntity.ok(excelHelper.exportTemplate(SampleEntity.class));
    }
}
