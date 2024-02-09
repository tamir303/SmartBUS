package com.project.smartbus.route.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;

@Configuration
public class GoogleRouteConfig {
    private final String apiUrl;
    private final String apiKey;
    private final String fieldMask;

    @Autowired
    public GoogleRouteConfig(@Value("${google.api.url}") String apiUrl,
                             @Value("${google.api.key}") String apiKey,
                             @Value("${google.api.fieldmask}") String fieldMaks) {
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
        this.fieldMask = fieldMaks;
    }

    public WebClient.Builder RouteAPI() {
        return WebClient.builder()
                .baseUrl(this.apiUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("X-Goog-Api-Key", this.apiKey)
                .defaultHeader("X-Goog-FieldMask", this.fieldMask);
    }
}