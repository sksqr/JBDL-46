package com.example.L08jdbcdemo;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO {

    public Product createProductInTxn(Product product){
        Connection con = null;
        boolean autoCommit = false;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "user1", "Pass@123");
            autoCommit = con.getAutoCommit();
            con.setAutoCommit(false);
            String insertStm = "insert into product values (null,?,?)";
            PreparedStatement statement = con.prepareStatement(insertStm);
            statement.setString(1, product.getName());
            statement.setDouble(2,product.getPrice());
            statement.execute();
            con.commit();
        } catch (SQLException exc) {
            try {
                con.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } finally {
            try {
                con.setAutoCommit(autoCommit);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return product;
    }

    public Product createProductWithPrepared(Product product){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "user1", "Pass@123");
            String insertStm = "insert into product values (null,?,?)";
            PreparedStatement statement = con.prepareStatement(insertStm);
            statement.setString(1, product.getName());
            statement.setDouble(2,product.getPrice());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return product;
    }


    public Product createProduct(Product product){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "user1", "Pass@123");
            Statement statement = con.createStatement();
            String insertStm = "insert into product values (null,'"+product.getName()+"',"+product.getPrice()+")";
            statement.execute(insertStm);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return product;
    }


    public List<Product> getAllProduct(){
        List<Product> products = new ArrayList<>();
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "user1", "Pass@123");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from product");
            while (resultSet.next()){
                Product product = new Product(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getDouble("price"));
                System.out.println(product);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return products;
    }
}
