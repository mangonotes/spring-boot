package com.example.jpah2.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.example.jpah2.dao.repository"})
@ConfigurationProperties(prefix = "jpa")
@Setter
public class JpaConfig {
    private String entity;
    private String generate_ddl;
    private String dialect;

    @Bean
    LocalContainerEntityManagerFactoryBean createEntityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan(entity);
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(createJpaVendorAdapter());
        factoryBean.setJpaProperties(createProperties());
        factoryBean.afterPropertiesSet();
        return factoryBean;
    }



    private JpaVendorAdapter createJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    private Properties createProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", generate_ddl);
        properties.setProperty(
                "hibernate.dialect", dialect);
        return properties;
    }

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
