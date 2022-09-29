package codeAcademy.bookswakeus.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/login", "/public/**").permitAll()
                .antMatchers("/private/**").authenticated()
                .anyRequest()
                .authenticated();

        http
                .formLogin()
                .permitAll()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/books")
                .failureUrl("/login?error=login.failed")
                .passwordParameter("password")
                .usernameParameter("username");

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());

        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .antMatchers("/h2/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder encoder = PasswordEncoderFactories
                .createDelegatingPasswordEncoder();


        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder);
    }

}
