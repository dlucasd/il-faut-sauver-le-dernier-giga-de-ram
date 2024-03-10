package com.onepoint.moduleparsing;

import com.onepoint.moduleparsing.service.ParsingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ModuleParsing {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ModuleParsing.class, args);
		ctx.getBean(ParsingService.class).run();
	}

}
