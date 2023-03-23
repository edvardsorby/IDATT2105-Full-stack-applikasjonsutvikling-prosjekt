package no.ntnu.ecomback.security;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests()
                .requestMatchers("/token").permitAll()
                .requestMatchers("/api/users/register").permitAll()
                .requestMatchers("/api/items/getItems").permitAll()
                .requestMatchers("/api/items/get/category").permitAll()
                .requestMatchers("/api/items/{id}").permitAll()
                .requestMatchers("/api/categories/getCategories").permitAll()
                .requestMatchers("/api/items/get/keyword").permitAll()
                .requestMatchers("/api/items/add").authenticated() // Require authentication for the addItem endpoint
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

