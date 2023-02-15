package DKSPACE.PhamarERP.auth.controller;


import DKSPACE.PhamarERP.auth.dto.login.LoginReqDto;
import DKSPACE.PhamarERP.auth.dto.login.LoginResDto;
import DKSPACE.PhamarERP.auth.dto.register.RegisterReqDto;
import DKSPACE.PhamarERP.auth.dto.register.RegisterResDto;
import DKSPACE.PhamarERP.auth.service.AuthenticationService;
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
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<RegisterResDto> register(@RequestBody RegisterReqDto dto){
        log.info("AuthenticationController start api /api/auth/register:  {}", dto);
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResDto> login(@RequestBody LoginReqDto dto){
        log.info("AuthenticationController start api /api/auth/login:  {}", dto);
        return ResponseEntity.ok(service.login(dto));
    }

}
