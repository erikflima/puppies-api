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
    	
    	//Criando um usuario em memoria, no qual pode acessar os endpoints
        UserDetails user = User.withUsername("admin_puppies_app")
					           .password( passwordEncoder().encode("IjyWSjHxAGiBCZ2pXAsxIgzLHQozp92lSX6pid0aqrPwN6GpEH") )
					           .roles("USER")
					           .build();
        
        return new InMemoryUserDetailsManager(user);
    }


    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {

        http.csrf(csrf -> csrf.disable() ) // Desabilita o CSRF.
					          .authorizeHttpRequests(auth -> auth
					          .anyRequest().authenticated() // Requer autenticacao para todas as requisicoes.
            )
					          
            .httpBasic( Customizer.withDefaults() );

        return http.build();

    }

}