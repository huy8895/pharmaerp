package DKSPACE.PhamarERP.auth.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "application.admin")
public record AdminConfig(String email,
                          String username,
                          String password,
                          String staffCode,
                          String lastname,
                          String firstname
) {
}
