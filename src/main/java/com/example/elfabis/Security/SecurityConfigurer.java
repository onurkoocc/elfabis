package com.example.elfabis.Security;


import com.example.elfabis.Entity.ERole;
import com.example.elfabis.Security.Jwt.AuthEntryPointJwt;
import com.example.elfabis.Security.Jwt.AuthTokenFilter;
import com.example.elfabis.Security.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] endPoints = new String[]{"/plans", "/academicians", "/courses", "/equivalentCourses", "/givenCourses", "/roles"};
        String[] formTrackingEndPoints = new String[]{"/formtrackings", "/formtrackings/**"};
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/auth/**").permitAll()
                .antMatchers("/test/**").permitAll()
                .regexMatchers(HttpMethod.GET).permitAll()
                .regexMatchers(HttpMethod.POST, endPoints).hasAuthority("MUDEKMEMBER")
                .regexMatchers(HttpMethod.PUT, endPoints).hasAuthority("MUDEKMEMBER")
                .regexMatchers(HttpMethod.DELETE, endPoints).hasAuthority("MUDEKMEMBER")
                .antMatchers(HttpMethod.POST, formTrackingEndPoints).hasAuthority("MUDEKMEMBER")
                .antMatchers(HttpMethod.PUT, formTrackingEndPoints).hasAnyAuthority("MUDEKMEMBER","COMMISSIONER","LECTURER")
                .antMatchers(HttpMethod.DELETE, formTrackingEndPoints).hasAuthority("MUDEKMEMBER")
                .anyRequest().authenticated();
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }


}