package com.company;

import com.company.view.ProductLineManager;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost/classicmodels";
//        String user = "root";
//        String pass = "481998";
//        String sql = "SELECT customerName from customers";
//        try {
//            Connection conn = DriverManager.getConnection(url, user, pass);
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(sql);
//            while (rs.next()) {
//                System.out.println("Name: " + rs.getString("customerName"));
//            }
//            conn.close();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
        ProductLineManager demo = new ProductLineManager();
        demo.run();
    }
}
