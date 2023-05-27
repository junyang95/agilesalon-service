package com.miniprogram.agilesalonservice.config;

import com.zaxxer.hikari.HikariConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

@Configuration
public class DatabaseConfig {
    @Autowired
    private Environment activeEnv;

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfig.class);

    @Bean
    @Primary
    public HikariConfig hikariDataSourceConfig() {
        HikariConfig hikariConfig = new HikariConfig();

        LOGGER.info("current active profile: [{}]", (Object[]) activeEnv.getActiveProfiles());

        LOGGER.info("datasource.url is [{}]", activeEnv.getProperty("spring.datasource.url"));
        hikariConfig.setJdbcUrl(activeEnv.getProperty("spring.datasource.url"));

        LOGGER.info("datasource.driverClassName is [{}]", activeEnv.getProperty("spring.datasource.driverClassName"));
        hikariConfig.setDriverClassName(activeEnv.getProperty("spring.datasource.driverClassName"));

        LOGGER.info("datasource.username is [{}]", activeEnv.getProperty("spring.datasource.username"));
        hikariConfig.setUsername(activeEnv.getProperty("spring.datasource.username"));

        LOGGER.info("datasource.password is [{}]", activeEnv.getProperty("spring.datasource.password"));
        hikariConfig.setPassword(activeEnv.getProperty("spring.datasource.password"));

        LOGGER.info("hikari.pool-name is [{}]", activeEnv.getProperty("spring.datasource.hikari.pool-name"));
        hikariConfig.setPoolName(activeEnv.getProperty("spring.datasource.hikari.pool-name"));

        hikariConfig.setConnectionTimeout(10 * 1000);
        hikariConfig.setValidationTimeout(3 * 1000);
        hikariConfig.setMaxLifetime(30 * 1000);
        hikariConfig.setMaximumPoolSize(10);
        return hikariConfig;
    }
}
