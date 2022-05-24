package me.hyeonic.springjdbcbatch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppConfig {

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return jdbcTemplate();
    }
}
