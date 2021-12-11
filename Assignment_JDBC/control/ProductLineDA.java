package com.company.control;
import java.sql.*;
import com.company.model.ProductLine;

import java.sql.ResultSet;
import java.util.ArrayList;


public class ProductLineDA extends DataAccess {
    public ArrayList<ProductLine> selectAllProductLines() throws SQLException {
        ResultSet rs = selectAll("productLines");
        ArrayList<ProductLine> lines = new ArrayList<>();
        while (rs.next()) {
            String productLine = rs.getString("productLine");
            String textDesc = rs.getString("textDescription");
            String htmlDesc = rs.getString("htmlDescription");
            ProductLine pline = new ProductLine(productLine, textDesc, htmlDesc);
            lines.add(pline);
        }
        return lines;
    }
    public ProductLine selectProductLine(String productLine) throws SQLException {
        // prepare SQL statement with info
        // execute statement
        // get info from ResultSet to create a ProductLine object to return
        ProductLine productLine1 = new ProductLine();
        Connection conn = connectDB();
        String sql = "SELECT productLine, textDescription, htmlDescription FROM productLines WHERE productLine = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString( 1, productLine);
        ResultSet res = stm.executeQuery();
        while(res.next()) {
            String resultProducLine = res.getString("productLine");
            String resultTextDescrip = res.getString("textDescription");
            String resultHtmlDesrip = res.getString("htmlDescription");
            productLine1 = new ProductLine(resultProducLine, resultTextDescrip, resultHtmlDesrip);
        }
            conn.close();
//            throw new UnsupportedOperationException();
        return productLine1;
    }
    public boolean deleteProductLine(ProductLine pline) throws SQLException {
        DataAccess dataAccess = new DataAccess();
        String table = "ProductLines";
        String idCol = "productLine";
//        System.out.print("Table name: ");
//        String table = scan.nextLine();
//        System.out.print("Column name: ");
//        String idCol = scan.nextLine();
        return dataAccess.deleteByID(table, idCol, pline.getProductLine());
        // call deleteByID
    }

    public boolean editProductLine(ProductLine pline) throws SQLException{
        // get info from pline
        // prepare SQL statement with info
        // execute statement
//        throw new UnsupportedOperationException();
        Connection conn = connectDB();
        String table = "productlines";
        String id = "productLine";
        String sql = "UPDATE " + table + " SET textDescription = ? WHERE " + id + "= ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString( 1, pline.getTextDescription());
        stm.setString(2, pline.getProductLine());
        int nRows = stm.executeUpdate();
        conn.close();
        return nRows != 0;
    }
}
