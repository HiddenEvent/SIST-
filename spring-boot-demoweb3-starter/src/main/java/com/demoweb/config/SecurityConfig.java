package com.demoweb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demoweb.security.DemoWebPasswordEncoder;
import com.demoweb.security.DemoWebUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DemoWebUserService userDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http	.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/home.action").permitAll()
				.antMatchers("/account/**").permitAll()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/**").authenticated()
			.and()
				.formLogin()
				.loginPage("/account/login.action")
				.usernameParameter("memberId")
				.passwordParameter("passwd")
				.defaultSuccessUrl("/home")
			.and()
				.logout()
				//.logoutUrl("/logout.action")
				.logoutSuccessUrl("/home.action")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
			.and()
				.csrf().disable();
	}
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new DemoWebPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.inMemoryAuthentication()
//			.withUser("iamuserone").password("{noop}9922").roles("MEMBER")
//			.and()
//			.withUser("iamadminone").password("{noop}9922").roles("ADMIN");
		
//		auth.jdbcAuthentication()
//			.dataSource(dataSource)
//			.usersByUsernameQuery("SELECT member_id, passwd, active FROM tbl_member WHERE member_id = ?")
//			.authoritiesByUsernameQuery("SELECT member_id, role_name FROM tbl_member_roles WHERE member_id = ?")
//			.passwordEncoder(passwordEncoder());
		
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
			
		
	}
	
}








