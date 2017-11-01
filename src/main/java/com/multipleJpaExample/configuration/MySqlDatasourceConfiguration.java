package com.multipleJpaExample.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by Vishal Maurya on 1/11/17.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mySqlEntityManagerFactory",
        transactionManagerRef = "mySqlTransactionManager",
        basePackages = {"com.multipleJpaExample.repositories.mysql"})
public class MySqlDatasourceConfiguration {
  @Autowired
  private JpaProperties jpaProperties;

  @Bean("mySqlDatasource")
  @ConfigurationProperties(prefix = "spring.datasource.mysql")
  public DataSource oracleDataSource() {
    return  DataSourceBuilder.create().build();
  }

  @Bean("mySqlEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean oracleEntityManager(EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("mySqlDatasource") DataSource dataSource) {
    Map<String,String> props = this.jpaProperties.getHibernateProperties(dataSource);
    props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
    LocalContainerEntityManagerFactoryBean request = entityManagerFactoryBuilder
            .dataSource(oracleDataSource())
            .packages("com.multipleJpaExample.entities.mysql")
            .persistenceUnit("mySqlEntityManager")
            .properties(props)
            .build();
    return request;
  }

  @Bean("mySqlTransactionManager")
  public PlatformTransactionManager oracleTransactionManager(@Qualifier("mySqlEntityManagerFactory") EntityManagerFactory oracleEntityManager) {
    return new JpaTransactionManager(oracleEntityManager);
  }

}
