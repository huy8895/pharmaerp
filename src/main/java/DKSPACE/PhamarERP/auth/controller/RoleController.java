package DKSPACE.PhamarERP.auth.controller;

import DKSPACE.PhamarERP.auth.dto.role.RoleCreateDTO;
import DKSPACE.PhamarERP.auth.dto.role.RoleDTO;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService service;

    /**
     * 1. Danh sách quyền - List Role
     * @return
     */
    @GetMapping
    public ResponseEntity<Object> listRoles() {
        return ResponseEntity.ok(service.listRoles(Pageable.unpaged()));
    }


    /**
     * 2. Tạo mới quyền - Create Role
     */
    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@RequestBody @Valid RoleCreateDTO roleReqDto) {
        return ResponseEntity.ok(service.createRole(roleReqDto));
    }

    /**
     * 3. Cập nhật quyền - Update Role
     */
    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody @Valid Role role) {
        return ResponseEntity.ok(service.partialUpdate(role));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> detailRole(@PathVariable Long id) {
        return ResponseEntity.ok(service.detailRole(id));
    }

    /**
     * - Xóa quyền: chỉ cho phép xóa khi quyền assign cho ai.
     * @param id roleId
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable Long id) {
        service.deleteRole(id);
        return ResponseEntity.noContent()
                             .build();
    }
}
