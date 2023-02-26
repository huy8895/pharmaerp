package DKSPACE.PhamarERP.auth.controller;

import DKSPACE.PhamarERP.auth.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/privileges")
@RequiredArgsConstructor
public class PrivilegeController {
    private final PrivilegeService service;

    @GetMapping
    public Object getAll(){
        return service.getAll();
    }
}
