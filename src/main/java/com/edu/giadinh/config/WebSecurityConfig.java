package com.edu.giadinh.config;

import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

//	@Bean
//	public UserDetailsService mongoUserDetails() {
//		return new CustomUserDetailsService();
//	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		UserDetailsService userDetailsService = mongoUserDetails();
//		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll().antMatchers("/dangkytuyensinh").permitAll()
				.antMatchers("/xemHoSoDangKyTuyenSinh**").permitAll().antMatchers("/xemHoSo**").permitAll()
				.antMatchers("/dashboard/**").permitAll().antMatchers("/dashboard2/**").hasAuthority("ADMIN")
				.anyRequest().authenticated().and().csrf().disable().formLogin()
				.successHandler(customizeAuthenticationSuccessHandler).loginPage("/login")
				.failureUrl("/login?error=true").usernameParameter("email").passwordParameter("password").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
				.exceptionHandling();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/login").permitAll().antMatchers("/signup")
//				.permitAll().antMatchers("/dangkytuyensinh").permitAll().antMatchers("/xemhoso").permitAll()
//				.antMatchers("/dashboard/**").permitAll().antMatchers("/dashboard2/**");
//
//	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/img/**");
	}

	@Bean
	public JavaMailSender getJavaMailSender() throws MessagingException, IOException {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("giadinhuniversity.exam@gmail.com");
		mailSender.setPassword("Vietanh123");
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.smtp.starttls.enable", "true");

		return mailSender;
	}

}
