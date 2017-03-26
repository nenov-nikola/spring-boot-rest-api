package com.scar.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication( scanBasePackages = "com.scar")
@Import({DataSourceConfig.class, WebServletApplicationInitializer.class})
public class CarsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarsApplication.class, args);
    }
}
