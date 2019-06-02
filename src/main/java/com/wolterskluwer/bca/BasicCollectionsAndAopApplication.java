package com.wolterskluwer.bca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = "com.wolterskluwer.bca")
@Import({ AppConfig.class })
@EnableAutoConfiguration
public class BasicCollectionsAndAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicCollectionsAndAopApplication.class, args);
	}

}
