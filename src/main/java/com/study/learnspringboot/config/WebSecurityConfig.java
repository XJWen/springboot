package com.study.learnspringboot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity security)throws Exception{
        security
                .authorizeRequests()
                //设置不拦截路径
                .antMatchers("/","/hello","/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/chat")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder)throws Exception{
        builder
                .inMemoryAuthentication()
                .withUser("wxj").password("wxj").roles("USER")
                .and()
                .withUser("wxj_admin").password("admin").roles("ADMIN");
    }

    @Override
    public void configure(WebSecurity security)throws Exception{
        security
                .ignoring()
                .antMatchers("/resource/static/**");
    }
}
