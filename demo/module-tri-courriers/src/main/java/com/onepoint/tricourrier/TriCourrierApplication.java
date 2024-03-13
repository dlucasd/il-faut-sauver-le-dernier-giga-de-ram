package com.onepoint.tricourrier;

import com.onepoint.tricourrier.service.TriCourrierService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(TriCourrierConfiguration.class)
public class TriCourrierApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TriCourrierApplication.class, args);
		ctx.getBean(TriCourrierService.class).runForestRun();
	}

}
