package com.booksphere.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScan(
        basePackages = "com.booksphere",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        }
)
public class AppConfig {

    private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);

    // Database Properties
    @Value("${db.driver}") private String dbDriver;
    @Value("${db.url}") private String dbUrl;
    @Value("${db.password}") private String dbPassword;
    @Value("${db.username}") private String dbUsername;

    // Hikari Connection Pool Properties
    @Value("${hikari.pool-name}") private String hikariPoolName;
    @Value("${hikari.maximum-pool-size}") private int hikariMaxPoolSize;
    @Value("${hikari.minimum-idle}") private int hikariMinIdle;
    @Value("${hikari.Idle-timeout:600000}") private long hikariIdleTimeout;
    @Value("${hikari.connection-timeout:30000}") private long hikariConnectionTimeout;
    @Value("${hikari.max-lifetime:1800000}") private long hikariMaxLifetime;

    // Hibernate Properties
    @Value("${hibernate.dialect}") private String hibernateDialect;
    @Value("${hibernate.show_sql}") private String hibernateShowSql;
    @Value("${hibernate.format_sql}") private String hibernateFormatSql;
    @Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2ddl;
//    @Value("${hibernate.physical_naming_strategy:org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl}")
//    private String hibernateNamingStrategy;
    @Value("${hibernate.jdbc.batch_size:20}") private String hibernateBatchSize;

    @Bean
    public DataSource dataSource() {
        LOG.info("Initializing Hikari Data Source for pool: {}", hikariPoolName);
        HikariConfig config = new HikariConfig();
        config.setPoolName(hikariPoolName);
        config.setDriverClassName(dbDriver);
        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUsername);
        config.setPassword(dbPassword);

        config.setMaximumPoolSize(hikariMaxPoolSize);
        config.setMinimumIdle(hikariMinIdle);
        config.setIdleTimeout(hikariIdleTimeout);
        config.setConnectionTimeout(hikariConnectionTimeout);
        config.setMaxLifetime(hikariMaxLifetime);

        // Typical query to test if connection is alive
        config.setConnectionTestQuery("SELECT 1");

        return new HikariDataSource(config);
    }

    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.setProperty(AvailableSettings.DIALECT, hibernateDialect);
        props.setProperty(AvailableSettings.SHOW_SQL, hibernateShowSql);
        props.setProperty(AvailableSettings.FORMAT_SQL, hibernateFormatSql);
        props.setProperty(AvailableSettings.HBM2DDL_AUTO, hibernateHbm2ddl);
//        props.setProperty(AvailableSettings.PHYSICAL_NAMING_STRATEGY, hibernateNamingStrategy);
        props.setProperty(AvailableSettings.STATEMENT_BATCH_SIZE, hibernateBatchSize);
        return props;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.booksphere.model");
        factory.setHibernateProperties(hibernateProperties());
        return factory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }
}