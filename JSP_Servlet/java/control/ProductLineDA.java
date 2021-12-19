package control;
import model.ProductLine;

import java.sql.*;


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
            lines.add(new ProductLine(productLine, textDesc, htmlDesc));
        }
        conn.close();
        return lines;
    }
    public ProductLine selectProductLine(String productLine) throws SQLException {
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
        return productLine1;
    }
    public boolean deleteProductLine(String pline) throws SQLException {
        DataAccess dataAccess = new DataAccess();
        String table = "ProductLines";
        String idCol = "productLine";
        return dataAccess.deleteByID(table, idCol, pline);
    }

    public boolean editProductLine(ProductLine pline) throws SQLException{
        Connection conn = connectDB();
//        String table = "productLines";
//        String id = "productLine";
        String sql = "UPDATE productlines SET textDescription = ?, htmlDescription = ? WHERE productLine = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString( 1, pline.getTextDescription());
        stm.setString(2, pline.getHtmlDescription());
        stm.setString(3, pline.getProductLine());
        int nRows = stm.executeUpdate();
        conn.close();
        return nRows != 0;
    }
}

