package com.example.batchhelloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
@Slf4j
public class BatchHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchHelloWorldApplication.class, args);
	}

}
