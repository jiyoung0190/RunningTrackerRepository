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
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://ec2-54-74-60-70.eu-west-1.compute.amazonaws.com:5432/dbp3jul6u0mf3g?user=qpdyjfbkdqdowe&password=45cbcc9866b10934fa076690885f6aa1b31259678a681033f34cac37d27fddba");
        dataSourceBuilder.username("qpdyjfbkdqdowe");
        dataSourceBuilder.password("45cbcc9866b10934fa076690885f6aa1b31259678a681033f34cac37d27fddba");
        return dataSourceBuilder.build();
    }
}
