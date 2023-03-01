package DKSPACE.PhamarERP;

import DKSPACE.PhamarERP.auth.config.properties.AdminConfig;
import DKSPACE.PhamarERP.auth.config.properties.JwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {AdminConfig.class, JwtConfig.class})
public class PhamarErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhamarErpApplication.class, args);
	}

}
