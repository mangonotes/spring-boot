## Create Spring boot application with jpa without spring data
Its create h2 in memory database .
With below configurations
```
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
```