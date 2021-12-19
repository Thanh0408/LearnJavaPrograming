package view;

import control.PaymentDA;
import model.Payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@WebServlet({"/ServletPayment", "/ServletPayment_edit","/ServletPayment_delete"})
public class ServletPayment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        System.out.println("0000");
        switch (action){
            case "/ServletPayment_edit":
                System.out.println("1111");
                Edit(request,response);
                break;
            case "/ServletPayment_delete":
                Delete(request,response);
            case "/ServletPayment":
                System.out.println("0011");
                ShowAll(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void ShowAll(HttpServletRequest request, HttpServletResponse response){
        try{
            PaymentDA paymentDA = new PaymentDA();
            ArrayList<Payment> lists = paymentDA.selectAllPayments();
            request.setAttribute("lists",lists);
            request.getServletContext().getRequestDispatcher("/Payments/viewAllPayment.jsp").forward(request,response);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private void Edit(HttpServletRequest request,HttpServletResponse response) {
        try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            Integer cusNumb = Integer.valueOf(request.getParameter("cusNumb"));
            String checkNumb = request.getParameter("checkNumb");
            LocalDate pDate = LocalDate.parse(request.getParameter("pDate"));
            Double amount = Double.valueOf(request.getParameter("amount"));
            Payment p = new Payment(cusNumb, checkNumb, pDate, amount);
            PaymentDA paymentDA = new PaymentDA();

            if (paymentDA.editPayment(p)) {
                out.println("<script>alert('Update successful');window.location='/Homework4_dtt_war_exploded/ServletPayment'</script>");
            } else {
                out.println("<script>alert('Update false');window.location='/Homework4_dtt_war_exploded/ServletPayment'</script>");
            }
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void Delete(HttpServletRequest request, HttpServletResponse response) {
        try{
            String cusNumb = request.getParameter("checkNumb");
            PaymentDA paymentDA = new PaymentDA();
            if ( paymentDA.deletePayment(cusNumb)) {
                System.out.println("Delete done");;
            }else {
                System.out.println("Delete false");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
