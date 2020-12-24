package com.gagan.server.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan(basePackages = {"com.gagan.server.domain"})
@EnableJpaRepositories(basePackages = {"com.gagan.server.repos"})
@EnableTransactionManagement
public class DomainConfig {
}
