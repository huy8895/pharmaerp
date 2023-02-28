package DKSPACE.PhamarERP.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

/**
 * Properties specific to PhamarErp.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 */

@Getter
@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private final Security security = new Security();

    @Getter
    public static class Security {
        private final Authentication authentication = new Authentication();

        @Data
        public static class Authentication {
            private final Jwt jwt = new Jwt();

            @Data
            public static class Jwt {
                private String secret;
                private long tokenValidityInSeconds = 1800;
            }
        }
    }
}
