package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.auth.model.CustomUserDetails;
import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.auth.repository.RoleRepository;
import DKSPACE.PhamarERP.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByEmailOrUsername(username)
                                  .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        final var allByUser = roleRepository.findAllByUser(user);
        user.setRoles(allByUser);
        final var simpleGrantedAuthorities = allByUser
                                           .stream()
                                           .map(role -> new SimpleGrantedAuthority(
                                                                            role.getNameEn()))
                                           .toList();
        return new CustomUserDetails(user, simpleGrantedAuthorities);
    }
}
