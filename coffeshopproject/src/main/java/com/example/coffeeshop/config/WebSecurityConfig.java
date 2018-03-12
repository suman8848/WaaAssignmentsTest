package com.example.coffeeshop.config;

import com.example.coffeeshop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()

            .authorizeRequests()
				.antMatchers(
						"/",
						"/js/**",
						"/css/**",
						"/img/**",
						"/webjars/**").permitAll()
                .antMatchers("/", "/home", "/index","/register","/api/**","/addProduct").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
				.loginPage("/login")
            	.permitAll()
            	.and()
          .logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler);
    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
				.withUser("admin").password("admin").roles("ADMIN")
				.and()
				.withUser("suman").password("suman").roles("USER");
//		auth.userDetailsService(userDetailsService);
//		auth.inMemoryAuthentication().withUser("super").password("pw").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}
}