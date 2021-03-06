//package com.example.restcriteriaspringboot.config;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableWebMvc
//public class HibernateConfig {
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("com.example.springbootdemo.model");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//
//        return sessionFactory;
//    }
//
//    @Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//        HibernateTransactionManager transactionManager
//                = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/springempl");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("32167");
//
//        return dataSource;
//    }
//    //hibernate.hbm2ddl.auto Автоматически проверяет или экспортирует
//    // DDL схемы в базу данных при создании SessionFactory.
//    // С помощью create-drop схема базы данных будет удалена,
//    // если SessionFactory будет закрыта явно.
//    //список возможных вариантов:
//    //validate: проверить схему, не вносить изменения в базу данных.
//    //update: обновить схему.
//    //create: создает схему, уничтожая предыдущие данные.
//    //create-drop: отказаться от схемы, когда SessionFactory закрывается явно,
//    // как правило, когда приложение остановлено.
//
//    //org.hibernate.dialect пакет абстрагирует диалект SQL базовой базы данных
//    private final Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty(
//                "hibernate.hbm2ddl.auto", "create-drop");
//        hibernateProperties.setProperty(
//                "hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
//        return hibernateProperties;
//    }
//
//}
//
//
//
