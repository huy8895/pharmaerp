package DKSPACE.PhamarERP;

import DKSPACE.PhamarERP.auth.config.properties.AdminConfig;
import DKSPACE.PhamarERP.auth.config.properties.JwtConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.TimeZone;

@SpringBootApplication
@EnableConfigurationProperties(value = {AdminConfig.class, JwtConfig.class})
@EnableAsync
public class PhamarErpApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PhamarErpApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
	}
	
}
