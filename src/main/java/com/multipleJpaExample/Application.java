package com.multipleJpaExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Vishal Maurya on 31/10/17.
 */
@SpringBootApplication(exclude ={ DataSourceAutoConfiguration.class})
@ComponentScan("com.multipleJpaExample.*")
public class Application {
  public static void main(String ...args) {
    SpringApplication.run(Application.class);
  }
}
