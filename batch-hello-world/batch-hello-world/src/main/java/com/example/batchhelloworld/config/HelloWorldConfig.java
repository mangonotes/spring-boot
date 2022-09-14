package com.example.batchhelloworld.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@AllArgsConstructor
@Slf4j
public class HelloWorldConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private  final JobLauncher jobLauncher;

    @Bean
    public Step helloWorldStep(){
    return stepBuilderFactory.get("hello-world")
            .tasklet((stepContribution, chunkContext) -> {
                log.info("hello world step {}", LocalDateTime.now());
             return    RepeatStatus.FINISHED;
            })
            .build();
    }

    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("job").start(helloWorldStep()).build();
    }


}


