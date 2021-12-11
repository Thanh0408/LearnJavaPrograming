package com.company.view;

import com.company.MenuProgram;
import com.company.control.DataAccess;
import com.company.control.ProductLineDA;
import com.company.model.ProductLine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductLineManager extends MenuProgram {
    @Override
    protected void printMenu() {
        System.out.println("You can choice 1 of options below:");
        System.out.println("1. Show all data of ProductLine table.");
        System.out.println("2. Search by ProductLine.");
        System.out.println("3. Delete by ProductLine.");
        System.out.println("4. Edit by ProductLine.");
        System.out.println("5. Exit.");
        // 1. Show all
        // 2. Search by product line
        // 3. Delete by product line
        // 4. Edit by product line
    }

    @Override
    protected void doTask(int choice) {
        // use ProductLineDA to complete tasks
        switch (choice){
            case 1: showProducLineTable(); break;
            case 2: searchProductLine(); break;
            case 3: deleteProduct(); break;
            case 4: editProductLine(); break;
        }
    }

    private Connection connectDB() throws SQLException {
        String url = "jdbc:mysql://localhost/classicmodels";
        String user = "root";
        String pass = "481998";
        Connection conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    private void showProducLineTable() {
        ProductLineDA productLineDA = new ProductLineDA();
        ArrayList<ProductLine> dataList = new ArrayList<>();
        try {
            dataList = (ArrayList<ProductLine>)(productLineDA.selectAllProductLines()).clone();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < dataList.size(); i++) {
            System.out.print("( ProductLine: " + dataList.get(i).getProductLine() + " ||");
            System.out.print(" TextDescription: " +dataList.get(i).getTextDescription() + " ||");
            System.out.println(" HtmlDescription: " +dataList.get(i).getHtmlDescription() + " )");
        }
    }

    private void searchProductLine() {
        ProductLineDA productLineDA = new ProductLineDA();

        System.out.print("Enter productLine: ");
        Scanner scanner = new Scanner(System.in);
        String searchingLine = scanner.nextLine();
        try{
            ProductLine prod = productLineDA.selectProductLine(searchingLine);

            if (prod.getProductLine() == null) {
                System.out.println("Do not have that product line: " + searchingLine);
            } else {
                showInfo(prod);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void deleteProduct() {
        try{
            ProductLineDA productLineDA = new ProductLineDA();
            ProductLine productLine = new ProductLine();
            Scanner scan = new Scanner(System.in);
            System.out.print("Delete Product line: ");
            String pName = scan.nextLine();
            productLine.setProductLine(pName);
            if(productLineDA.deleteProductLine(productLine)){
                System.out.println("Delete successfully!");
            } else {
                System.out.println("Delete not successfully!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void editProductLine() {
        try{
            Scanner scan = new Scanner(System.in);
            ProductLine pl = new ProductLine();
            ProductLineDA plDA = new ProductLineDA();

            System.out.print("ProductLine will be edited: ");
            String plineName = scan.nextLine();
            System.out.println("TextDescription to be: ");
            String plineTextdes = scan.nextLine();
            pl.setProductLine(plineName);
            pl.setTextDescription(plineTextdes);
            if (plDA.selectProductLine(pl.getProductLine()) != null){
                plDA.editProductLine(pl);
                System.out.println("Successfully!");
            }
            else {
                System.out.println("False! Have not produc line: " + pl.getProductLine());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void showInfo(ProductLine p) {
        System.out.print("( ProductLine: " + p.getProductLine() + " ||");
        System.out.print(" TextDescription: " +p.getTextDescription() + " ||");
        System.out.println(" HtmlDescription: " +p.getHtmlDescription() + " )");
    }
}
