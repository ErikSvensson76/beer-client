package com.example.beerclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient(WebClientProperties properties){
        return WebClient.builder().baseUrl(properties.getBaseUrl()).build();
    }
}
