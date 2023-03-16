package DKSPACE.PhamarERP.auth.controller;

import DKSPACE.PhamarERP.auth.service.PermissionService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/permissions")
@RequiredArgsConstructor
@ResponseWrapper
public class PermissionController {
    private final PermissionService service;

    @GetMapping
    public Object getAll(@ParameterObject Pageable pageable){
        return service.getAll(pageable);
    }
}
