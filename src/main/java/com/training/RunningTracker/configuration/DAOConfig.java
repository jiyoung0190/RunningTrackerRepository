package com.training.RunningTracker.configuration;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"com.training.RunningTracker"})
public class DAOConfig {

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
       // dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("postgres://tnfygsgwsgziaq:1b40374c8f2029f19d2560572618e26826949700a344f0a9f7e8dabcb4ea8cc2@ec2-176-34-105-15.eu-west-1.compute.amazonaws.com:5432/d39d50ar6ebfmr");
        dataSourceBuilder.username("tnfygsgwsgziaq");
        dataSourceBuilder.password("1b40374c8f2029f19d2560572618e26826949700a344f0a9f7e8dabcb4ea8cc2");
        return dataSourceBuilder.build();
    }
}
