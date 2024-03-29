package DKSPACE.PhamarERP.auth.config;

import DKSPACE.PhamarERP.i18n.config.I18NMessageResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final I18NMessageResolver messageResolver;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                .disable()
                    .cors(c -> c
                            .configurationSource(request -> {
                                CorsConfiguration cors = new CorsConfiguration();
                                cors.setAllowedOrigins(Collections.singletonList("*"));
                                cors.setAllowedMethods(Collections.singletonList("*"));
                                cors.setAllowedHeaders(Collections.singletonList("*"));
                                return cors;
                            })
                    )
                .authorizeHttpRequests()
                .requestMatchers("").permitAll()
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/sw.js", "/favicon.ico", "/error")
                    .permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPointImpl());


        return httpSecurity.build();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPointImpl(){
        return new AuthenticationFailureHandlerImpl(messageResolver);
    }
}
