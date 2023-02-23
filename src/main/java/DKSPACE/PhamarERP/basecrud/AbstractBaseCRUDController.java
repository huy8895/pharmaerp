package DKSPACE.PhamarERP.basecrud;

import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public abstract class AbstractBaseCRUDController<E extends BaseCRUDEntity, S extends BaseCRUDService<E>> {
    protected final S service;

    protected AbstractBaseCRUDController(S service) {
        this.service = service;
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
}