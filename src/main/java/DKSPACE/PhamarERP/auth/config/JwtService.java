package DKSPACE.PhamarERP.auth.config;

import DKSPACE.PhamarERP.auth.config.properties.JwtConfig;
import DKSPACE.PhamarERP.auth.dto.jwt.JwtTokenDTO;
import DKSPACE.PhamarERP.auth.model.Permission;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtConfig jwtConfig;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String getJWTFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public JwtTokenDTO generateToken(User user) {
        HashMap<String, Object> claims = new HashMap<>();
        Set<Role> roleSet = getRoles(user);

        List<String> permissions = getPermissions(roleSet);

        List<String> roles = roleSet.stream()
                                    .map(Role::getNameEn)
                                    .toList();

        claims.put("roles", roles);
        claims.put("permissions", permissions);
        claims.put("type", user.getType());
        String token = generateToken(claims, user);
        return JwtTokenDTO.builder()
                          .token(token)
                          .roles(roles)
                          .permissions(permissions)
                          .expirationIn(jwtConfig.expirationToken())
                          .build();
    }

    private Set<Role> getRoles(User user) {
        return user.getRoles()
                   .stream()
                   .filter(Role::getIsActive)
                   .collect(Collectors.toSet());
    }

    private List<String> getPermissions(Set<Role> roleSet) {
        return roleSet.stream()
                      .map(Role::getPermissions)
                      .flatMap(Collection::stream)
                      .filter(Permission::getIsActive)
                      .map(Permission::getKey)
                      .map(Enum::name)
                      .toList();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails) {
        return Jwts.builder()
                   .setClaims(extraClaims)
                   .setSubject(userDetails.getUsername())
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.expirationToken()))
                   .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                   .compact();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsTFunction) {
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    ;

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                   .setSigningKey(getSignInKey())
                   .build()
                   .parseClaimsJws(token)
                   .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtConfig.secretKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
