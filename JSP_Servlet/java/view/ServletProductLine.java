package view;

import control.ProductLineDA;
import model.ProductLine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.System.out;

@WebServlet({"/ServletProductLine","/ServletProductLine_edit","/ServletProductLine_delete"})
public class ServletProductLine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        switch (action){
            case "/ServletProductLine_edit":
                Edit(request,response);
                break;
            case "/ServletProductLine_delete":
                Delete(request,response);
            case "/ServletProductLine":
                ShowAll(request,response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void ShowAll(HttpServletRequest request, HttpServletResponse response){
        try{
            ProductLineDA productLineDA = new ProductLineDA();
            ArrayList<ProductLine> lists = productLineDA.selectAllProductLines();
            request.setAttribute("lists", lists);
            request.getServletContext().getRequestDispatcher("/ProductLines/viewAllProductLines.jsp").forward(request,response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    protected void Edit(HttpServletRequest request,HttpServletResponse response){
        try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String namePl = request.getParameter("namePl");
            String textPl = request.getParameter("textPl");
            String htmlPl = request.getParameter("htmlPl");
            ProductLine p = new ProductLine(namePl,textPl,htmlPl);
            ProductLineDA productLineDA = new ProductLineDA();
            if (productLineDA.editProductLine(p)){
                out.println("<script>alert('Update successful');window.location='/Homework4_dtt_war_exploded/ServletProductLine'</script>");
            } else {
                out.println("<script>alert('Update false');window.location='/Homework4_dtt_war_exploded/ServletProductLine'</script>");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    protected void Delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String plName = request.getParameter("pline");
            System.out.println(plName);
            ProductLineDA productLineDA = new ProductLineDA();
            if(productLineDA.deleteProductLine(plName)){
                System.out.println("Delete done");;
            }else {
                System.out.println("Delete false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
