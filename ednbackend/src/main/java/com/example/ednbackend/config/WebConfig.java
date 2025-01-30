package com.example.ednbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configure CORS to allow all paths and the React frontend domain
        registry.addMapping("/**")  // Allow all paths
                .allowedOrigins("https://reimagined-spork-954jr96v4ggcpqrg-3000.app.github.dev") // React frontend's URL (GitHub Codespaces)
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow specific HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow credentials (if needed)
    }
}
