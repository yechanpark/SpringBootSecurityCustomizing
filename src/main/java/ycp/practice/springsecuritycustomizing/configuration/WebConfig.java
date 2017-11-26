package ycp.practice.springsecuritycustomizing.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import ycp.practice.springsecuritycustomizing.authentication.CustomAuthenticationProvider;
import ycp.practice.springsecuritycustomizing.authentication.CustomUserDetailsService;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	// Add <? implements AuthenticationProvider>
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest()
			  //.authenticated()
				.permitAll()

				.and().httpBasic().and().csrf().disable();
	}


}
