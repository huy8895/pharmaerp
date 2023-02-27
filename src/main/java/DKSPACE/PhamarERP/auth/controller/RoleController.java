package DKSPACE.PhamarERP.auth.controller;

import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService service;

    @GetMapping
    public ResponseEntity<List<Role>> listRoles() {
        return ResponseEntity.ok(service.findAll(Pageable.unpaged()).getContent());
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody @Valid Role role) {
        return ResponseEntity.ok(service.createRole(role));
    }
}
