package DKSPACE.PhamarERP.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@OpenAPIDefinition
@Configuration
public class SpringdocConfig {
    @Bean
    public OpenAPI baseOpenAPI() {
        List<Server> servers = List.of(
                new Server().url("http://localhost:8080"),
                new Server().url("dev-server:8080"));

        final var info = new Info().title("DKSPACE.PhamarERP")
                                   .version("1.0.0")
                                   .description("documentation for api");

        final var components = new Components()
                .addSecuritySchemes("bearer-key",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"));
        return new OpenAPI().info(info)
                            .servers(servers)
                            .components(components);
    }

    @Bean
    public GroupedOpenApi authApi() {
        String[] paths = {"/api/auth/**"};
        return GroupedOpenApi.builder()
                             .group("Auth")
                             .pathsToMatch(paths)
                             .build();
    }

    @Bean
    public GroupedOpenApi sampleApi() {
        String[] paths = {"/api/sample/**"};
        return GroupedOpenApi.builder()
                             .group("Sample")
                             .pathsToMatch(paths)
                             .build();
    }


}
