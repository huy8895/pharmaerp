package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.auth.model.CustomUserDetails;
import DKSPACE.PhamarERP.auth.model.Permission;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByEmailOrUsername(username)
                                  .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        final var simpleGrantedAuthorities = user.getRoles()
                                           .stream()
                                           .map(role -> new SimpleGrantedAuthority(role.getNameEn()))
                                           .toList();

        final var  listPermission = user.getRoles()
                                         .stream()
                                         .map(Role::getPermissions)
                                         .flatMap(Collection::stream)
                                         .map(Permission::getKey)
                                         .map(Enum::name)
                                         .collect(Collectors.toSet());

        return new CustomUserDetails(user, simpleGrantedAuthorities,listPermission);
    }
}
