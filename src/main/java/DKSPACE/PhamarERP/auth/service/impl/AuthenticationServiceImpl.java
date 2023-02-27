package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.config.JwtService;
import DKSPACE.PhamarERP.auth.dto.login.LoginReqDto;
import DKSPACE.PhamarERP.auth.dto.login.LoginResDto;
import DKSPACE.PhamarERP.auth.dto.register.RegisterReqDto;
import DKSPACE.PhamarERP.auth.dto.register.RegisterResDto;
import DKSPACE.PhamarERP.auth.exception.UserAlreadyExistException;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import DKSPACE.PhamarERP.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public RegisterResDto register(RegisterReqDto dto) {
        userRepository.findByEmail(dto.getEmail())
                      .ifPresent((user) -> {
                          throw new UserAlreadyExistException("Username Already Exist");
                      });

        // TODO: 24/2/2023
        final User user = User.builder()
//                              .firstname(dto.getFirstname())
//                              .lastname(dto.getLastname())
                              .email(dto.getEmail())
                              .password(passwordEncoder.encode(dto.getPassword()))
//                              .role(Role.USER)
                              .build();

        userRepository.save(user);
        final var token = jwtService.generateToken(user);
        return RegisterResDto.builder()
                             .token(token)
                             .build();
    }

    @Override
    public LoginResDto login(LoginReqDto dto) {
        final var authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );

        final var token = jwtService.generateToken((User) authenticate.getPrincipal());
        return LoginResDto.builder()
                          .token(token)
                          .build();
    }
}
