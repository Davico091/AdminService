package com.example.admin.service.configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.example.admin.service")
@EnableWebMvc
@Import({WebInitializer.class})
public class ApplicationConfiguration {

}
