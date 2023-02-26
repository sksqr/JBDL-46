package com.example.L08springjdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SpringJDBCProductDao implements IProductDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private RowMapper<Product> productRowMapper;

    @Value("${sql.product.insert}")
    private String insertSql;

    @Value(("${sql.product.findById}"))
    private String findByIdSql;
    @Override
    public Product createProduct(Product product) {
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("name", product.getName());
        in.addValue("price",  product.getPrice());
        namedParameterJdbcTemplate.update(insertSql, in);

//        String insertStm = "insert into product values (null,'"+product.getName()+"',"+product.getPrice()+")";
//        jdbcTemplate.execute(insertStm);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        String query = "Select * from product";
        List<Product> products = jdbcTemplate.query(query,productRowMapper);
        return products;
    }

    @Override
    public Product getProductById(Integer id) {
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("id", id);
        Product product = namedParameterJdbcTemplate.queryForObject(findByIdSql,in,productRowMapper);
        return product;
    }
}
