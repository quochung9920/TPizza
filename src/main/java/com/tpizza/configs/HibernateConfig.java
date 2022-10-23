package com.tpizza.configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:databases.properties")
public class HibernateConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setPackagesToScan("com.tpizza.pojos");
        factoryBean.setDataSource(getDataSource());
        factoryBean.setHibernateProperties(hibernateProperties());


        return factoryBean;
    }
    
    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("hibernate.connection.driverClass"));
        dataSource.setUrl(env.getProperty("hibernate.connection.url"));
        dataSource.setUsername(env.getProperty("hibernate.connection.username"));
        dataSource.setPassword(env.getProperty("hibernate.connection.password"));

        return dataSource;
    }

    public Properties hibernateProperties(){
        Properties props = new Properties();
        props.setProperty(SHOW_SQL, env.getProperty("hibernate.showSql"));
        props.setProperty(DIALECT, env.getProperty("hibernate.dialect"));

        return props;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());

        return transactionManager;
    }
    
}
