package DKSPACE.PhamarERP.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
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
        return new OpenAPI().info(info)
                            .servers(servers)
                ;
    }

    @Bean
    public GroupedOpenApi productApi() {
        String[] paths = {"/api/auth/**"};
        return GroupedOpenApi.builder()
                             .group("Auth")
                             .pathsToMatch(paths)
                             .build();
    }


}
