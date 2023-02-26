package com.example.L08springjdbcdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class ProjectConfig {

//    @Bean
//    public DataSource mysqlDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
//        dataSource.setUsername("user1");
//        dataSource.setPassword("Pass@123");
//        return dataSource;
//    }

    @Bean
    public RowMapper<Product> productRowMapper(){
        return new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product(rs.getInt("id"),rs.getString("name"),rs.getDouble("price"));
                return product;
            }
        };
    }




}
