package com.onepoint.javaperf;

import com.onepoint.javaperf.service.CatchMeIfYouCan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaperfApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(JavaperfApplication.class, args);
		ctx.getBean(CatchMeIfYouCan.class).run();
	}

}
