package control;

import model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PaymentDA extends DataAccess{
    public ArrayList<Payment> selectAllPayments() throws SQLException {
        ResultSet rs = selectAll("Payments");
        ArrayList<Payment> lists = new ArrayList<>();
        while(rs.next()) {
            Integer customerNumb = rs.getInt("customerNumber");
            String checkNumb = rs.getString("checkNumber");
            LocalDate time = LocalDate.parse(rs.getString("paymentDate"));
            Double amount = rs.getDouble("amount");
            lists.add(new Payment(customerNumb,checkNumb,time,amount));
        }
        conn.close();
        return lists;
    }

    public Payment selectPayment(String customerNumb, String checkNumb) throws SQLException {
        Payment payment = new Payment();
        Connection conn = connectDB();
        String sql = "SELECT customerNumber, checkNumber, paymentDate, amount FROM payments WHERE customerNumber = ? AND checkNumber = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString( 1, customerNumb);
        stm.setString(2, checkNumb);
        ResultSet res = stm.executeQuery();
        while(res.next()) {
            Integer cusNumb = res.getInt("customerNumber");
            String checkNum = res.getString("checkNumber");
            LocalDate date = LocalDate.parse(res.getString("paymentDate"));
            Double amount = res.getDouble("amount");
            payment = new Payment(cusNumb,checkNum,date,amount);
        }
        return payment;
    }

    public boolean deletePayment(String checkNumb) throws SQLException {
        DataAccess dataAccess = new DataAccess();
        String table = "Payments";
        String idCol = "checkNumber";
        return dataAccess.deleteByID(table, idCol, checkNumb);
    }

    public boolean editPayment(Payment payment) throws SQLException{
        Connection conn = connectDB();
        String sql = "UPDATE payments SET paymentDate = ?, amount = ? WHERE customerNumber = ? AND checkNumber = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString( 1, payment.getPaymentDate());
        stm.setString(2,payment.getAmount());
        stm.setInt(3, payment.getCustomerNumber());
        stm.setString(4, payment.getCheckNumber());
        int nRows = stm.executeUpdate();
        conn.close();
        return nRows != 0;
    }
}
