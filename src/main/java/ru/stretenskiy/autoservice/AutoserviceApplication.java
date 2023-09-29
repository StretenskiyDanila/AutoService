package ru.stretenskiy.autoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AutoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoserviceApplication.class, args);
	}

}
