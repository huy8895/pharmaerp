package DKSPACE.PhamarERP.auth.service;


import DKSPACE.PhamarERP.auth.dto.login.LoginReqDto;
import DKSPACE.PhamarERP.auth.dto.register.RegisterReqDto;
import DKSPACE.PhamarERP.auth.dto.register.RegisterResDto;

public interface AuthenticationService {
    RegisterResDto register(RegisterReqDto dto);

    RegisterResDto login(LoginReqDto dto);
}
