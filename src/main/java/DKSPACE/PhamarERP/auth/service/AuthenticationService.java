package DKSPACE.PhamarERP.auth.service;


import DKSPACE.PhamarERP.auth.dto.login.LoginReqDto;
import DKSPACE.PhamarERP.auth.dto.login.LoginResDto;
import DKSPACE.PhamarERP.auth.dto.register.RegisterReqDto;
import DKSPACE.PhamarERP.auth.dto.register.RegisterResDto;

public interface AuthenticationService {
    RegisterResDto register(RegisterReqDto dto);

    LoginResDto login(LoginReqDto dto);
}
