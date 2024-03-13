package fr.onepoint.demo.modulereporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ReportingConfiguration.class)
public class ModuleReportingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ModuleReportingApplication.class, args);
		ctx.getBean(ReportingRunner.class).runForestRun();
	}

}
