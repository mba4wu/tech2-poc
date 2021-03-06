package com.beta.wheelsup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

/**
 * Created by mburns on 1/19/16.
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.beta.wheelsup"})
@PropertySource({"classpath:persistence-mysql.properties"})
@ComponentScan(basePackages = "com.beta.wheelsup")
public class AppConfig {

    @Autowired
    Environment env;

    /*
    Entity Manager
     */
    @Bean(destroyMethod = "close")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPersistenceUnitName(DB_NAME);
        factory.setPackagesToScan("com.beta.wheelsup");
        factory.setJpaVendorAdapter(jpaAdapter());
        factory.setJpaProperties(hibernateProperties());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    /*
    Hibernate Selection As JPA Provider
     */
    @Bean
    public JpaVendorAdapter jpaAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.SQL_SERVER);
        return adapter;
    }

    /*
    JPA TransactionManager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

    /*
    Spring's SQL Exception Translator
    */
    @Bean
     public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /*
     *DataSource Properties Loader
     */
    DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    public static final String DB_NAME = "wheelsup";

    /*
     *Hibernate Properties Loader
    */
    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect",
                        env.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql",
                        env.getProperty("hibernate.show_sql"));
            }
        };
    }

}



