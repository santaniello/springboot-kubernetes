package com.example.k8s.springbootkubernetes.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.properties")
public class WelcomeConfiguration {

    private String nameUser;
    private List<Role> roles;
}
