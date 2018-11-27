package com.study.learnspringboot.customizer;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

//自定义配置Servlet容器
public class MyServletContainer
        implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
//        factory.setPort(8888);
    }

    @Bean
    public ConfigurableWebServerFactory webServerFactory(){
        JettyServletWebServerFactory jetty = new JettyServletWebServerFactory();
        jetty.setPort(9999);
        return jetty;
    }
}
