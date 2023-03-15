package DKSPACE.PhamarERP.auth.controller;


import DKSPACE.PhamarERP.auth.dto.login.LoginReqDto;
import DKSPACE.PhamarERP.auth.dto.login.LoginResDto;
import DKSPACE.PhamarERP.auth.service.AuthenticationService;
import DKSPACE.PhamarERP.midleware.response.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@ResponseWrapper
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/login")
    public Object login(@RequestBody LoginReqDto dto){
        log.info("AuthenticationController start api /api/auth/login:  {}", dto);
        return service.login(dto);
    }

}
