package DKSPACE.PhamarERP;

import DKSPACE.PhamarERP.auth.config.properties.AdminConfig;
import DKSPACE.PhamarERP.auth.config.properties.JwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableConfigurationProperties(value = {AdminConfig.class, JwtConfig.class})
@EnableAsync
public class PhamarErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhamarErpApplication.class, args);
	}

}
