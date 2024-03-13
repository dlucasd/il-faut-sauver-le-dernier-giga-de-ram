package com.onepoint.tricourrier;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"fr.onepoint.demo"})
@EntityScan(basePackages = {"fr.onepoint.demo"})
@EnableJpaRepositories(basePackages = {"fr.onepoint.demo"})
@EnableCaching
public class TriCourrierConfiguration {
}
