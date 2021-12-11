package com.company.control;

import java.sql.*;

public class DataAccess {
    protected  Connection conn;
    protected Connection connectDB() throws SQLException {
        String url = "jdbc:mysql://localhost/classicmodels";
        String user = "root";
        String pass = "481998";
        Connection conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    protected ResultSet selectAll(String table) throws SQLException {
        conn = connectDB();
        String sql = "SELECT * from " + table;
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
//        conn.close();
        return res;
    }

    protected boolean deleteByID(String table, String idCol, String id) throws SQLException {
        conn = connectDB();
        String sql = "DELETE FROM " + table + " WHERE " + idCol + " = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, id);

        int nRows = stm.executeUpdate();
        conn.close();
        return nRows != 0;
    }
}
