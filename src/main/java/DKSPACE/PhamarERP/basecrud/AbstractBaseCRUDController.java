package DKSPACE.PhamarERP.basecrud;

import DKSPACE.PhamarERP.helper.excel.ExcelHelper;
import DKSPACE.PhamarERP.helper.excel.impl.ExcelHelperImpl;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public abstract class AbstractBaseCRUDController<E extends BaseCRUDEntity, S extends BaseCRUDService<E>> {
    protected final S service;
    protected final Class<E> entity;
    private final ExcelHelper excelHelper;

    protected AbstractBaseCRUDController(S service, Class<E> entity) {
        this.service = service;
        this.entity = entity;
        this.excelHelper = new ExcelHelperImpl();
    }

    @PostMapping
    public ResponseEntity<E> create(@RequestBody @Valid E entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<E>> saveAll(@RequestBody @Valid List<E> entity) {
        return ResponseEntity.ok(service.saveAll(entity));
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

    @GetMapping("/export-template")
    public ResponseEntity<byte[]> exportTemplate() {
        return ResponseEntity.ok(excelHelper.exportTemplate(this.entity));
    }

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<E>> exportFileExcel(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(excelHelper.readFile(file, this.entity));
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> importFileExcel() {
        return ResponseEntity.ok(excelHelper.writeFile(service.findAll(Pageable.unpaged())
                                                              .getContent(), this.entity));
    }
}