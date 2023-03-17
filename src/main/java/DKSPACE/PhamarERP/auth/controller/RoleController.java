package DKSPACE.PhamarERP.auth.controller;

import DKSPACE.PhamarERP.auth.aop.HasPermission;
import DKSPACE.PhamarERP.auth.dto.role.RoleCreateDTO;
import DKSPACE.PhamarERP.auth.dto.role.RoleUpdateDTO;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.auth.service.RoleService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Role", description = "The Role API")
@SecurityRequirement(name = "bearerAuth") // indicate that all endpoints require authentication
public class RoleController {
    private final RoleService service;
    
    /**
     * 1. Danh sách quyền - List Role
     */
    @GetMapping
    @HasPermission(PermissionKeyEnum.LIST_ROLE)
    @Operation(summary = "Danh sách quyền - List Role") 
    public Object listRoles(@ParameterObject Pageable pageable) {
        return service.listRoles(pageable);
    }
    
    /**
     * 2. Tạo mới quyền - Create Role
     */
    @PostMapping
    @HasPermission(PermissionKeyEnum.CREATE_ROLE)
    @Operation(summary = "Tạo mới quyền - Create Role") 
    public Object createRole(@RequestBody @Valid RoleCreateDTO roleReqDto) {
        return service.createRole(roleReqDto);
    }
    
    /**
     * 3. Cập nhật quyền - Update Role
     */
    @PutMapping
    @HasPermission(PermissionKeyEnum.UPDATE_ROLE)
    @Operation(summary = "Cập nhật quyền - Update Role") 
    
    public Object updateRole(@RequestBody @Valid RoleUpdateDTO role) {
        return service.updateRole(role);
    }
    
    /**
     * 4 - Xóa quyền: chỉ cho phép xóa khi quyền assign cho ai.
     * @param id roleId
     */
    @DeleteMapping("/{id}")
    @HasPermission(PermissionKeyEnum.DELETE_ROLE)
    @Operation(summary = "Xóa quyền: chỉ cho phép xóa khi quyền assign cho ai.") 
    
    public Object deleteRole(@PathVariable Long id) {
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
    @Operation(summary = "Xem chi tiết role, để trả data role + permission cho FE hiển thị") 
    
    public Object detailRole(@PathVariable Long id) {
        return service.detailRole(id);
    }
}
