package com.jsonar.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//public class JSonarServerApplication extends SpringBootServletInitializer {
//	@Override
//	protected SpringApplicationBuilder configure(
//			SpringApplicationBuilder builder) {
//		return builder.sources(JSonarServerApplication.class);
//	}
//
//	public static void main(String[] args) {
//		SpringApplication sa = new SpringApplication(
//				JSonarServerApplication.class);
//		sa.run(args);
//	}
//}

public class JSonarServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(JSonarServerApplication.class, args);
	}
}
