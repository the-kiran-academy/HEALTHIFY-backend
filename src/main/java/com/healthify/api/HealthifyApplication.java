package com.healthify.api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author RAM
 *
 */
@SpringBootApplication

public class HealthifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthifyApplication.class, args);
		System.out.println("started");
	}
	

}
