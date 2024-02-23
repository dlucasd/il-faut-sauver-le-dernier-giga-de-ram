package fr.onepoint.demo.modulereporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ModuleReportingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ModuleReportingApplication.class, args);
		ctx.getBean(ReportingRunner.class).process();
	}

}
