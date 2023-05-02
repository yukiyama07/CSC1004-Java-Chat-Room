package cn.com.UChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Main application
@SpringBootApplication
public class UChatWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UChatWebApplication.class, args);
    }

    // package
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UChatWebApplication.class);
    }
}
