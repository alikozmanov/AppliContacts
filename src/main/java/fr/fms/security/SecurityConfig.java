package fr.fms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

    @Configuration
    @EnableWebSecurity
    @EnableMethodSecurity // Active la sécurité au niveau des méthodes
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
            return http
                    .csrf(csrf -> csrf.disable()) // Désactive CSRF pour simplifier les tests
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/admin/**").hasRole("ADMIN")
                            .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                            .anyRequest().authenticated()
                    )
                    .sessionManagement(session -> session
                            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // Définit la gestion de session
                    )
                    .formLogin(Customizer.withDefaults()) // Active le formulaire de connexion par défaut
                    .httpBasic(Customizer.withDefaults()) // Active l'authentification basique
                    .userDetailsService(userDetailsService)
                    .build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public UserDetailsService userDetailsService() {
            UserDetails admin = User.withUsername("azerty")
                    .password(passwordEncoder().encode("12345"))
                    .roles("ADMIN")
                    .build();

            UserDetails user = User.withUsername("user")
                    .password(passwordEncoder().encode("12345"))
                    .roles("USER")
                    .build();
// Authentification en mémoire
            return new InMemoryUserDetailsManager(admin, user);
        }
    }

