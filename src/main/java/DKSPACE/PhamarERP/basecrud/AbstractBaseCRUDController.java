package DKSPACE.PhamarERP.basecrud;

import DKSPACE.PhamarERP.helper.excel.ExcelHelper;
import DKSPACE.PhamarERP.helper.excel.impl.ExcelHelperImpl;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Lớp trừu tượng cho các controller CRUD cơ bản
 * - Các controller này sẽ có các phương thức chung như: tạo, lưu danh sách, lấy chi tiết, lấy tất cả, cập nhật và xóa
 * - Các controller này sẽ sử dụng một service cơ bản và một entity cơ bản
 * - Các controller này cũng có thể xuất và nhập file Excel cho entity của chúng
 **/
@ResponseWrapper(excludes = {"exportTemplate","exportFileExcel"})
public abstract class AbstractBaseCRUDController<E extends BaseCRUDEntity,
        S extends BaseCRUDService<E>,
        C extends Criteria<E>> {
    
    protected final S service;
    protected final Class<E> entity;
    protected final ExcelHelper excelHelper;

    protected AbstractBaseCRUDController(S service, Class<E> entity) {
        this.service = service;
        this.entity = entity;
        this.excelHelper = new ExcelHelperImpl();
    }

    @PostMapping
    @Operation(summary="Tạo mới")
    @HasBaseCRUDPermission(BaseCRUDAction.CREATE)
    public Object create(@RequestBody @Valid E entity) {
        return service.save(entity);
    }

    @PostMapping("/save-list")
    @Operation(summary="Lưu danh sách")
    @HasBaseCRUDPermission(BaseCRUDAction.IMPORT)
    public Object saveList(@RequestBody @Valid List<E> entity) {
        return service.saveList(entity);
    }

    @GetMapping("/{id}")
    @Operation(summary="Lấy thông tin chi tiết")
    @HasBaseCRUDPermission(BaseCRUDAction.DETAIL)
    public Object getDetail(@PathVariable Long id) {
        return service.findOne(id);
    }
    
    @GetMapping
    @Operation(summary = "Lấy danh sách và lọc theo tiêu chí")
    @HasBaseCRUDPermission(BaseCRUDAction.LIST)
    public Object getListByCriteria(@ParameterObject Pageable pageable,
                                    @ParameterObject C criteria) {
        return service.findByCriteria(pageable, criteria);
    }

    @PutMapping
    @Operation(summary="Cập nhật")
    @HasBaseCRUDPermission(BaseCRUDAction.UPDATE)
    public Object update(@RequestBody E entity) {
        return service.partialUpdate(entity);
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Xóa")
    @HasBaseCRUDPermission(BaseCRUDAction.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.softDelete(id);
        return ResponseEntity.noContent()
                             .build();
    }

    @GetMapping("/export-template-import")
    @Operation(summary="Xuất template để nhập")
    @HasBaseCRUDPermission(BaseCRUDAction.IMPORT)
    public ResponseEntity<byte[]> exportTemplate() {
        return ResponseEntity.status(HttpStatus.OK)
                             .headers(this.getHttpHeaders("-template-" + this.entity.getSimpleName()))
                             .body(excelHelper.exportTemplate(this.entity));
    }

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary="Nhập dữ liệu từ file Excel")
    @HasBaseCRUDPermission(BaseCRUDAction.IMPORT)
    public Object importFileExcel(@RequestParam("file") MultipartFile file) {
        return excelHelper.readFile(file, this.entity);
    }

    @GetMapping("/export")
    @Operation(summary="Xuất dữ liệu ra file Excel")
    @HasBaseCRUDPermission(BaseCRUDAction.EXPORT)
    public ResponseEntity<byte[]> exportFileExcel() {
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