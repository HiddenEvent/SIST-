package com.demoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(
	exclude = {
			HttpEncodingAutoConfiguration.class
	}
)
public class MvcBootStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcBootStarterApplication.class, args);
	}

}
