package DKSPACE.PhamarERP.auth.config;

import DKSPACE.PhamarERP.auth.dto.jwt.JwtTokenDTO;
import DKSPACE.PhamarERP.auth.model.Permission;
import DKSPACE.PhamarERP.auth.model.Role;
import DKSPACE.PhamarERP.auth.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {

    //https://www.allkeysgenerator.com/
    private static final String SECRET_KEY = "34743777217A25432A462D4A614E645267556B58703273357538782F413F4428";
    public static final int EXPIRATION_TOKEN = 1000 * 60 * 60 * 24; //1DAY

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
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
        String token = generateToken(claims, user);
        return JwtTokenDTO.builder()
                          .token(token)
                          .roles(roles)
                          .permissions(permissions)
                          .expirationIn(EXPIRATION_TOKEN)
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
                   .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TOKEN))
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
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
