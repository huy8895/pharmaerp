package DKSPACE.PhamarERP.config;


import DKSPACE.PhamarERP.midleware.HandlerInterceptorImpl;
import DKSPACE.PhamarERP.midleware.PermissionInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
  private final PermissionInterceptor permissionInterceptor;
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new HandlerInterceptorImpl());
    registry.addInterceptor(this.permissionInterceptor);
  }
}
