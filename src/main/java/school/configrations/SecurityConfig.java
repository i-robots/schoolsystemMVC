package school.configrations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import school.security.LogoutHandler;
import school.security.SuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserDetailsService userDetailsService;
	
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
		  auth.userDetailsService(userDetailsService)
	          .passwordEncoder(bCryptPasswordEncoder);
	  } 
	  
	  @Bean
      public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	      return new SuccessHandler();
	  }
	    
	  @Bean
	  public LogoutSuccessHandler logoutSuccessHandler() {
	      return new LogoutHandler();
	  }
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		 
		 http.authorizeRequests()
		     .antMatchers("/").permitAll()
		     .antMatchers("/login").permitAll()
		     .antMatchers("/contact").permitAll()
		     .antMatchers("/about").permitAll()
		     .antMatchers("/Student").permitAll()
		     .antMatchers("/Student/register").permitAll()
		     .antMatchers("/Student/profile").hasAuthority("STUDENT")
		     .antMatchers("/Staff").permitAll()
		     .antMatchers("/Staff/Teacher").permitAll()
		     .antMatchers("/teachersArea").hasAuthority("TEACHER")
		     .antMatchers("/Director").hasAuthority("DIRECTOR")
		     .antMatchers("/Cashier").hasAuthority("CASHIER")
		     .antMatchers("/studentList").hasAuthority("TEACHER")
		     .antMatchers("/PostGrade").hasAuthority("TEACHER")
		     .anyRequest().authenticated()
		     .and()
		     	.formLogin()
		     			.loginPage("/login")
		     			.failureUrl("/login?error=true")
		     			.successHandler(myAuthenticationSuccessHandler())
		     .and()
		     	.logout()
		     			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		     			.logoutSuccessUrl("/")
		     			.logoutSuccessHandler(logoutSuccessHandler())
	
	     	.and()
		     	.exceptionHandling()
		     	.accessDeniedPage("/access-denied");
	   
	  }
	 
	 @Override
	 public void configure(WebSecurity webSecurity) throws Exception {
		 
		 webSecurity.ignoring()
		 			.antMatchers("/resources/**","/static/**","/css/**","/js/**","/images/**");
		 
	 }
}