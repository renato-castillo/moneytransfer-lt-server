package com.lt.moneytransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MoneytransferServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneytransferServerApplication.class, args);
	}

}
