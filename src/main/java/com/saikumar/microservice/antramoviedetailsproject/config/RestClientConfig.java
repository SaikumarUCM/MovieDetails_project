package com.saikumar.microservice.antramoviedetailsproject.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient create(){
        return RestClient.create();
    }

}
