package com.multipleJpaExample.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by Vishal Maurya on 1/11/17.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager",basePackages = {"com.multipleJpaExample.entities.postgres","com.multipleJpaExample.repositories.postgres"})
public class PostgresDatasourceConfiguration {
  @Autowired(required = false)
  private PersistenceUnitManager persistenceUnitManager;

  @Autowired
  private JpaProperties jpaProperties;

  @Value("${postgres.properties.hibernate.hbm2ddl.auto}")
  private String hbm2ddl;

  @Value("${postgres.properties.hibernate.current_session_context_class}")
  private String currentSessionContext;

  @Value("${postgres.properties.hibernate.dialect}")
  private String dialect;

  @Value("${postgres.properties.hibernate.physical_naming_strategy}")
  private String physicalNamingStrategy;

  @Value("${postgres.properties.hibernate.implicit_naming_strategy}")
  private String implicitNamingStrategy;



  @ConfigurationProperties(prefix = "spring.datasource.postgres")
  @Bean(name = "postgres.datasource")
  @Primary
  public DataSource dataSourcePostgres() {
    try {
      return DataSourceBuilder.create().build();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


  @Bean("postgresSessionFactory")
  public HibernateJpaSessionFactoryBean sessionFactory() {
    return new HibernateJpaSessionFactoryBean();
  }

  @Bean
  JdbcTemplate jdbcTemplate(@Qualifier(value = "postgres.datasource") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }


  @Bean("postgresEntityManagerFactory")
  @Primary
  public LocalContainerEntityManagerFactoryBean postgresEntityManager(EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("postgres.datasource") DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean request = entityManagerFactoryBuilder
            .dataSource(dataSource)
            .packages("com.multipleJpaExample.entities.postgres")
            .persistenceUnit("postgresEntityManager")
            .properties(jpaProperties())
            //   .properties(this.jpaProperties.getHibernateProperties(dataSource))
            .build();
    for (Map.Entry<String, String> entry : this.jpaProperties.getHibernateProperties(dataSource).entrySet()) {
      String key = entry.getKey().toString();
      String value = entry.getValue();
    }
    return request;
  }


  @Bean("postgresTransactionManager")
  @Primary
  public PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManagerFactory") EntityManagerFactory oracleEntityManager) {
    return new JpaTransactionManager(oracleEntityManager);
  }

  private Map<String, Object> jpaProperties() {
    Map<String, Object> properties = new HashMap();
    properties.put("hibernate.hbm2ddl.auto",hbm2ddl);
    properties.put("hibernate.current_session_context_class",currentSessionContext);
    properties.put("hibernate.dialect", dialect);
    properties.put("hibernate.physical_naming_strategy",physicalNamingStrategy);
    properties.put("hibernate.implicit_naming_strategy",implicitNamingStrategy);
    return properties;
  }

}
