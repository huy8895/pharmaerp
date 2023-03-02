package DKSPACE.PhamarERP.auth.service;


import DKSPACE.PhamarERP.auth.dto.login.LoginReqDto;
import DKSPACE.PhamarERP.auth.dto.login.LoginResDto;

public interface AuthenticationService {
    LoginResDto login(LoginReqDto dto);
}
