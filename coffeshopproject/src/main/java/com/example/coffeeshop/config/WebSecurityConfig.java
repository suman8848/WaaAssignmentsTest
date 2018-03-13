package com.example.coffeeshop.config;

import com.example.coffeeshop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private LoggingAccessDeniedHandler accessDeniedHandler;
	@Autowired
	private DataSource dataSource;

	@Value("${coffeeshop.person-auth-query}")
	private String personAuthQuery;
	@Value("${coffeeshop.person-author-query}")
	private String personAuthorQuery;

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/index","/register","/api/**","/addProduct",
						"/user/login ","/user/account/signup","/product/**","/person/**","/order/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin().loginPage("/user/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.defaultSuccessUrl("/")
            	.permitAll()
            	.and()
          .logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutSuccessUrl("/")
				.permitAll();
		http.csrf().disable();
//				.and()
//				.exceptionHandling();
				//.accessDeniedHandler(accessDeniedHandler);
    }
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(personAuthQuery)
				.passwordEncoder(passwordEncoder())
				.authoritiesByUsernameQuery(personAuthorQuery)
				.dataSource(dataSource);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.inMemoryAuthentication()
//				.withUser("admin").password("admin").roles("ADMIN")
//				.and()
//				.withUser("suman").password("suman").roles("USER");
////		auth.userDetailsService(userDetailsService);
////		auth.inMemoryAuthentication().withUser("super").password("pw").roles("ADMIN");
////		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//	}
}