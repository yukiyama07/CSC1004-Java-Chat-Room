package cn.com.UChat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// CORS configuration
@Configuration
public class CorsConfig {

    // Maximum validity period of CORS request (in seconds) (24 hours)
    private static final long MAX_AGE = 24 * 60 * 60;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // Set access source
        corsConfiguration.addAllowedOrigin("http://localhost:8888");
        // Set access source request header
        corsConfiguration.addAllowedHeader("*");
        // Set access source request method
        corsConfiguration.addAllowedMethod("*");
        // Set maximum validity period of CORS request (in seconds) (24 hours)
        corsConfiguration.setMaxAge(MAX_AGE);
        // Register CORS configuration
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}

