package com.example.beerclient.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "host")
@Getter
@Setter
public class WebClientProperties {

    private String baseUrl;

}
