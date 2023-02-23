package DKSPACE.PhamarERP.master_data.sample;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.helper.excel.ExcelHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> exportFileExcel(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(excelHelper.readFile(file, SampleEntity.class));
    }
    @GetMapping("/export")
    public ResponseEntity<?> importFileExcel() {
        return ResponseEntity.ok(excelHelper.writeFile(service.findAll(Pageable.unpaged())
                                                              .getContent(), SampleEntity.class));
    }
}
