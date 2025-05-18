package ro.upb.acs.worldcuptickets.ticketservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTSecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(AbstractHttpConfigurer::disable)
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/actuator/**").permitAll()
//                .requestMatchers("/api/v1/tickets/users/**").hasAuthority("SCOPE_ticket.read")
//                .requestMatchers( "/api/v1/tickets/matches/**").hasAuthority("SCOPE_ticket.write")
//                .requestMatchers("/api/v1/tickets/**").hasAuthority("SCOPE_ticket.delete")
//                .anyRequest().authenticated()
//            )
//            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
//
//        return http.build();
//    }
}