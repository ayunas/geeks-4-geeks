package com.geeks4geeks.spring.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoApp implements CommandLineRunner {

	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(MongoApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server running on port : " + port);
	}
}
