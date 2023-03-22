package DKSPACE.PhamarERP.auth.controller;

import DKSPACE.PhamarERP.auth.service.PermissionService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/permissions")
@RequiredArgsConstructor
@ResponseWrapper
@Tag(name = "Permission", description = "The Permission API")
@SecurityRequirement(name = "bearerAuth")
public class PermissionController {
    private final PermissionService service;
    
    @GetMapping
    @Operation(summary = "Get all permissions with pagination")
    public Object getAll(@ParameterObject Pageable pageable){
        return service.getAll(pageable);
    }
}
