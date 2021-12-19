package TSDV;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(value = "/ServletAnswer")
@WebServlet({"/Answer1","/Answer2","/Answer3","/Answer4"})
public class ServletAnswer extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            String action = request.getServletPath();
            switch (action) {
                case "/Answer1":
                    String grade = request.getParameter("grade");
                    double numb1 = Double.parseDouble(grade);
                    request.setAttribute("evaluate",evaluation(numb1));
                    request.setAttribute("grade",numb1);
                    request.getRequestDispatcher("Question_1.jsp").forward(request,response);
                    break;
                case "/Answer2":
                    String numb = request.getParameter("number");
                    int number, equal = 0;
                    if (numb != null) {
                        number = Integer.parseInt(numb);
                        equal = factorial(number);
                    }
                    request.setAttribute("result",equal);
                    request.setAttribute("number",numb);
                    request.getRequestDispatcher("Question_2.jsp").forward(request,response);
                    break;
                case "/Answer3":
                    String[] s2 = request.getParameterValues("lists");
                    String[] s1 = s2[0].split(",");
                    int sum = 0;
                    for (int i = 0; i < s1.length;i++) {
                        sum += Integer.parseInt(s1[i]);
                    }
                    System.out.println(sum);
                    request.setAttribute("sum",sum);
                    request.setAttribute("lists",s2[0]);
                    request.getRequestDispatcher("Question_3.jsp").forward(request,response);
                    break;
                case "/Answer4":
                    String user = request.getParameter("username");
                    String pass = request.getParameter("password");
                    if (user.equals("thanh") && pass.equals("1234")) {
                        request.getRequestDispatcher("Question_4_successful.jsp").forward(request,response);
                    }else{
                        request.getRequestDispatcher("Question_4.jsp").forward(request,response);
                    }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void destroy() {}

    public int factorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * factorial(number-1);
        }
    }

    public String evaluation(double number) {
        String evaluate;
        if(number >=8.5) evaluate = "Excellent";
        else if( number <8.5 && number >= 7.0) evaluate = "Good";
        else if(number < 7.0 && number >=5.5) evaluate = "Average";
        else if(number <5.5 && number >= 4) evaluate="Weak";
        else evaluate = "Fail";
        return evaluate;
    }
}