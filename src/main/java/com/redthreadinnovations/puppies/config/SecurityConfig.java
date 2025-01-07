package com.redthreadinnovations.puppies.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	
        return new BCryptPasswordEncoder();
    }

    
    @Bean
    public UserDetailsService userDetailsService() {
    	
    	//Creating a user in memory, which can access the endpoints.
        UserDetails user = User.withUsername("admin_puppies_app")
					           .password( passwordEncoder().encode("IjyWSjHxAGiBCZ2pXAsxIgzLHQozp92lSX6pid0aqrPwN6GpEH") )
					           .roles("USER")
					           .build();
        
        return new InMemoryUserDetailsManager(user);
    }


    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {

        http.csrf(csrf -> csrf.disable() ) //Disables CSRF.
					          .authorizeHttpRequests(auth -> auth
					          .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Allow access to Swagger endpoints without authentication.
					          .anyRequest().authenticated() //Require authentication for all requests.
            )
					          
            .httpBasic( Customizer.withDefaults() );

        return http.build();

    }

}