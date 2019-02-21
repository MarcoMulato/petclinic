/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.security;

/**
 *
 * @author AlexPS
 */
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.samples.petclinic.users.UserService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    DataSource dataSource;

    //@Autowired
    //@Qualifier("UserService")
    //private UserService userdetailservice;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userdetailservice);
        /*
        auth.inMemoryAuthentication()
        .passwordEncoder(passwordEncoder)
        .withUser("user").password(passwordEncoder.encode("admin")).roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN");*/
        //auth.jdbcAuthentication().usersByUsernameQuery("select nombre from users where nombre = ?").authoritiesByUsernameQuery("select rol from users where nombre = ?").dataSource(dataSource);
        auth
        .jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery("select nombre as principal, password as credentials, activo as active from users where nombre=?")
        .authoritiesByUsernameQuery("select nombre as principal, rol as role, activo as active   from users where nombre=?").rolePrefix("ROLE_").passwordEncoder(passwordEncoder);
        
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/login")
            .permitAll()
        .antMatchers("/**")
            .hasAnyRole("0","1","TRUE","FALSE")
        .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/welcome")
            .failureUrl("/login?error=true")
            .permitAll()
        .and()
            .logout()
            .logoutSuccessUrl("/login?logout=true")
            .invalidateHttpSession(true)
            .permitAll()
        .and()
            .csrf()
            .disable();
    }
    @Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**","/css/**","/static/**","/images/**","/js/**");
                
	}
}
