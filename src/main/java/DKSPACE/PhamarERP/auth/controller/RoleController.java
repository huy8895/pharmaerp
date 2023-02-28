package DKSPACE.PhamarERP.auth.controller;

import DKSPACE.PhamarERP.auth.dto.role.RoleCreateDTO;
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

    @GetMapping
    public ResponseEntity<Object> listRoles() {
        return ResponseEntity.ok(service.listRoles(Pageable.unpaged()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> detailRole(@PathVariable Long id) {
        return ResponseEntity.ok(service.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody @Valid RoleCreateDTO roleReqDto) {
        return ResponseEntity.ok(service.createRole(roleReqDto));
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody @Valid Role role) {
        return ResponseEntity.ok(service.partialUpdate(role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable Long id) {
        service.softDelete(id);
        return ResponseEntity.noContent()
                             .build();
    }
}
