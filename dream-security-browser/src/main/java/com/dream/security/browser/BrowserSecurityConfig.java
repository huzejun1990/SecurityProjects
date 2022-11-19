package com.dream.security.browser;

import com.dream.security.core.properties.SecurityProperties;
import com.dream.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * Created by huzejun
 * on 2019/4/3 16:31
 */

@Configuration
public class BrowserSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler dreamAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler dreamAuthenticationFailureHandler;

    @Autowired
    private DataSource dataSource;

//    @Qualifier("myUserDetailsService")
//    @Qualifier("userDetailsService")
    @Autowired
    @Qualifier("myUserDetailsService")
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {

        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(dreamAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
            .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(dreamAuthenticationSuccessHandler)
                .failureHandler(dreamAuthenticationFailureHandler)
                .and()      //验证码开始
            .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSecondes())
                .userDetailsService(userDetailsService)
            .and()
            .authorizeRequests()
            .antMatchers("/authentication/require",
                    securityProperties.getBrowser().getLoginPage(),
                    "/code/image").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .csrf().disable();
        /**
        http.formLogin()
            .loginPage("/authentication/require")
//            .loginPage("dream-signIn.html")
//            .loginProcessingUrl("dream-signIn.html")
            .loginProcessingUrl("/authentication/form")
            .successHandler(dreamAuthenticationSuccessHandler)
            .failureHandler(dreamAuthenctiationFailureHandler)
//
            .and()
            .authorizeRequests()
            .antMatchers("/authentication/require",
                    securityProperties.getBrowser().getLoginPage()).permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .csrf().disable();

        **/

    }


}
