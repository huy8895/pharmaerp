package DKSPACE.PhamarERP.auth.controller;


import DKSPACE.PhamarERP.auth.dto.login.LoginReqDto;
import DKSPACE.PhamarERP.auth.dto.login.LoginResDto;
import DKSPACE.PhamarERP.auth.service.AuthenticationService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@ResponseWrapper
@Tag(name = "Authentication", description = "The Authentication API")
public class AuthenticationController {
    private final AuthenticationService service;
    
    @PostMapping("/login")
    @Operation(summary = "Login with username and password")
    public Object login(@RequestBody LoginReqDto dto){
        log.info("AuthenticationController start api /api/auth/login:  {}", dto);
        return service.login(dto);
    }
}