package fr.onepoint.demo.modulereporting;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"fr.onepoint.demo"})
@EntityScan(basePackages = {"fr.onepoint.demo"})
@EnableJpaRepositories(basePackages = {"fr.onepoint.demo"})
@Configuration
public class ReportingConfiguration {

}
