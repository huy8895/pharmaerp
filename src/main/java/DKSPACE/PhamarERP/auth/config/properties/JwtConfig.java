package DKSPACE.PhamarERP.auth.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "application.jwt")
public record JwtConfig(String secretKey,
                        Integer expirationToken
) {
}
