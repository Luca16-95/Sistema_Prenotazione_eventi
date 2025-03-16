package com.example.provaconnessione;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.provaconnessione.service.CustomUserDetails;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfig {

	private final CustomUserDetails customUserDetails;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(request -> request.requestMatchers("/register", "/login", "/home").permitAll()
						.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
						.defaultSuccessUrl("/eventi", true).permitAll())
				.logout(logout -> logout.logoutSuccessUrl("/login").permitAll()).userDetailsService(customUserDetails);
		return http.build();
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
