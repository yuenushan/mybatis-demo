package com.example.spring.mybatis0320;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerExceptionResolver;

@SpringBootApplication
public class Mybatis0320Application implements CommandLineRunner {

    @Autowired
    private CityMapper cityMapper;

    @Bean
    public HandlerExceptionResolver sentryExceptionResolver() {
        return new io.sentry.spring.SentryExceptionResolver();
    }

    @Bean
    public ServletContextInitializer sentryServletContextInitializer() {
        return new io.sentry.spring.SentryServletContextInitializer();
    }

    public static void main(String[] args) {
        SpringApplication.run(Mybatis0320Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(cityMapper.selectCityById(1));
    }
}
