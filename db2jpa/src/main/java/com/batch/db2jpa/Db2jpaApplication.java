package com.batch.db2jpa;

import com.batch.db2jpa.dao.entity.entity.UserEntity;
import com.batch.db2jpa.dao.entity.entity.UserType;
import com.batch.db2jpa.dao.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@Slf4j
public class Db2jpaApplication {
@Autowired
	private DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(Db2jpaApplication.class, args);
	}

}
