package DKSPACE.PhamarERP.auth.controller;

import DKSPACE.PhamarERP.auth.aop.HasPermission;
import DKSPACE.PhamarERP.auth.dto.role.RoleCreateDTO;
import DKSPACE.PhamarERP.auth.dto.role.RoleDTO;
import DKSPACE.PhamarERP.auth.dto.role.RoleUpdateDTO;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.service.RoleService;
import DKSPACE.PhamarERP.midleware.response.ResponseWrapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@ResponseWrapper
public class RoleController {
    private final RoleService service;

    /**
     * 1. Danh sách quyền - List Role
     */
    @GetMapping
    @HasPermission(PermissionKeyEnum.LIST_ROLE)
    public ResponseEntity<Object> listRoles(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(service.listRoles(pageable));
    }


    /**
     * 2. Tạo mới quyền - Create Role
     */
    @PostMapping
    @HasPermission(PermissionKeyEnum.CREATE_ROLE)
    public ResponseEntity<RoleDTO> createRole(@RequestBody @Valid RoleCreateDTO roleReqDto) {
        return ResponseEntity.ok(service.createRole(roleReqDto));
    }

    /**
     * 3. Cập nhật quyền - Update Role
     */
    @PutMapping
    @HasPermission(PermissionKeyEnum.UPDATE_ROLE)
    public ResponseEntity<RoleDTO> updateRole(@RequestBody @Valid RoleUpdateDTO role) {
        return ResponseEntity.ok(service.updateRole(role));
    }

    /**
     * 4 - Xóa quyền: chỉ cho phép xóa khi quyền assign cho ai.
     * @param id roleId
     */
    @DeleteMapping("/{id}")
    @HasPermission(PermissionKeyEnum.DELETE_ROLE)
    public ResponseEntity<Role> deleteRole(@PathVariable Long id) {
        service.deleteRole(id);
        return ResponseEntity.noContent()
                             .build();
    }

    /**
     * 5 xem chi tiết role, để trả data role + permission cho FE hiển thị
     * @param id roleId
     */
    @GetMapping("/{id}")
    @HasPermission(PermissionKeyEnum.DETAIL_ROLE)
    public ResponseEntity<RoleDTO> detailRole(@PathVariable Long id) {
        return ResponseEntity.ok(service.detailRole(id));
    }
}
