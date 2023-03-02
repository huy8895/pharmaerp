package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.config.JwtService;
import DKSPACE.PhamarERP.auth.dto.login.LoginReqDto;
import DKSPACE.PhamarERP.auth.dto.login.LoginResDto;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResDto login(LoginReqDto dto) {
        final var authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );

        final var jwtTokenDTO = jwtService.generateToken((User) authenticate.getPrincipal());
        return LoginResDto.builder()
                          .token(jwtTokenDTO.getToken())
                          .roles(jwtTokenDTO.getRoles())
                          .permissions(jwtTokenDTO.getPermissions())
                          .expirationIn(jwtTokenDTO.getExpirationIn())
                          .build();
    }
}
