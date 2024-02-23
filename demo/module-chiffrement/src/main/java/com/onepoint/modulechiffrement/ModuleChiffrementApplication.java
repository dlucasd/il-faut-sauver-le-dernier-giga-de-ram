package com.onepoint.modulechiffrement;

import com.onepoint.modulechiffrement.service.ParseCourriers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ModuleChiffrementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ModuleChiffrementApplication.class, args);
		ctx.getBean(ParseCourriers.class).daVinciRun();
	}

}
