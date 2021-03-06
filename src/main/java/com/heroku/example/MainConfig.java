package com.heroku.example;

import java.net.URISyntaxException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.heroku.example")
public class MainConfig {

	  @Bean
	    public BasicDataSource dataSource() throws URISyntaxException {
	        String dbUrl = System.getenv("JDBC_DATABASE_URL");
	        String username = System.getenv("JDBC_DATABASE_USERNAME");
	        String password = System.getenv("JDBC_DATABASE_PASSWORD");

	        BasicDataSource basicDataSource = new BasicDataSource();
	        basicDataSource.setUrl(dbUrl);
	        basicDataSource.setUsername(username);
	        basicDataSource.setPassword(password);

	        return basicDataSource;
	    }

}