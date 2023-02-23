package DKSPACE.PhamarERP.basecrud;

import DKSPACE.PhamarERP.helper.excel.ExcelHelper;
import DKSPACE.PhamarERP.helper.excel.impl.ExcelHelperImpl;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public abstract class AbstractBaseCRUDController<E extends BaseCRUDEntity, S extends BaseCRUDService<E>> {
    protected final S service;
    protected final Class<E> entity;
    protected final ExcelHelper excelHelper;

    protected AbstractBaseCRUDController(S service, Class<E> entity) {
        this.service = service;
        this.entity = entity;
        this.excelHelper = new ExcelHelperImpl();
    }

    @PostMapping
    public ResponseEntity<E> create(@RequestBody @Valid E entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PostMapping("/save-list")
    public ResponseEntity<List<E>> saveList(@RequestBody @Valid List<E> entity) {
        return ResponseEntity.ok(service.saveList(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> getDetail(@PathVariable Long id) {
        return ResponseEntity.ok(service.findOne(id));
    }

    @GetMapping
    public ResponseEntity<Page<E>> getAll(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @PutMapping
    public ResponseEntity<E> update(@RequestBody E entity) {
        return ResponseEntity.ok(service.partialUpdate(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.softDelete(id);
        return ResponseEntity.noContent()
                             .build();
    }

    @GetMapping("/export-template-import")
    public ResponseEntity<byte[]> exportTemplate() {
        return ResponseEntity.status(HttpStatus.OK)
                             .headers(this.getHttpHeaders("-template-" + this.entity.getSimpleName()))
                             .body(excelHelper.exportTemplate(this.entity));
    }

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<E>> exportFileExcel(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(excelHelper.readFile(file, this.entity));
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> importFileExcel() {
        return ResponseEntity.status(HttpStatus.OK)
                             .headers(this.getHttpHeaders("-export-" + entity.getSimpleName()))
                             .body(excelHelper.writeFile(service.findAll(Pageable.unpaged())
                                                                .getContent(), this.entity));
    }

    private HttpHeaders getHttpHeaders(String filename) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8"));
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + System.currentTimeMillis() + filename + ".xls");
        return headers;
    }
}