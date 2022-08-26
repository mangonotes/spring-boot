package com.batch.db2jpa.batch.config;

import com.batch.db2jpa.batch.dto.UserDTO;
import com.batch.db2jpa.batch.processor.user.UserItemProcessor;
import com.batch.db2jpa.dao.entity.entity.UserEntity;
import com.batch.db2jpa.dao.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Configuration
@AllArgsConstructor
@Slf4j
public class JpaBatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final JobLauncher jobLauncher;
    private final UserRepository userRepository;

    @Bean

    public RepositoryItemReader<UserEntity> reader() {
        RepositoryItemReader<UserEntity> reader = new RepositoryItemReader<>();
        reader.setRepository(userRepository);
        reader.setMethodName("findAll");
        Map<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);
        reader.setSort(sorts);
        return reader;
    }

    @Bean
    public UserItemProcessor processor() {
        return new UserItemProcessor();
    }

    @Bean
    public FlatFileItemWriter<UserDTO> writer() {
        Resource outputResource = new FileSystemResource("output/outputData.csv");
        FlatFileItemWriterBuilder<UserDTO> userDTOFlatFileItemWriterBuilder = new FlatFileItemWriterBuilder<>();
        userDTOFlatFileItemWriterBuilder.resource(outputResource);
        userDTOFlatFileItemWriterBuilder.name("write-csv");
        userDTOFlatFileItemWriterBuilder.append(false)
                .delimited().delimiter(",")
                .names("name", "createdDate", "userType");
        return userDTOFlatFileItemWriterBuilder.build();
    }

    @Bean
    public Step processUser(ItemReader<UserEntity> reader, ItemProcessor<UserEntity, UserDTO> processor, ItemWriter<UserDTO> writer) {
        return stepBuilderFactory.get("user-")
                .<UserEntity, UserDTO>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

    }

    @Bean
    protected Job userJob(){
      return   jobBuilderFactory
              .get("user-job")
              .start(processUser(reader(), processor(), writer()))
              .build();
    }

    @Scheduled(fixedRate = 60*60*1000)
    public void processUserJob() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        jobLauncher.run(userJob(),  new JobParametersBuilder().addLong("uniq", System.currentTimeMillis()).toJobParameters());
        log.info("started {}", LocalDateTime.now());
    }


}
