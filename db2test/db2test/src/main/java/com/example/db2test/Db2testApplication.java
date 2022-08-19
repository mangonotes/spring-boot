package com.example.db2test;

import com.example.db2test.dao.entity.entity.UserEntity;
import com.example.db2test.dao.entity.entity.UserType;
import com.example.db2test.dao.repo.UserRepository;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Objects;

@SpringBootApplication
public class Db2testApplication {
private static Logger log = LoggerFactory.getLogger(Db2testApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(Db2testApplication.class, args);
	}
	@Bean
	@Transactional
	public CommandLineRunner create(UserRepository userRepository){
		return  (args) -> {
			if (!CollectionUtils.isEmpty(userRepository.findAll())){
				log.info("data is exist ");
				return ;
			}
			userRepository.save(new UserEntity(-1, "User1",LocalDateTime.now(), UserType.ADMIN));
			userRepository.save(new UserEntity(-1, "User2",LocalDateTime.now(), UserType.WRITER));
		};
	}
}

