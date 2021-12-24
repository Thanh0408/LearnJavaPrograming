package tsdv.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tsdv.model.Customer;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


@Controller
public class CustomerRegistration {
    ArrayList<Customer> arrayList = new ArrayList<>();
    int hasData = 0;

    CustomerRegistration(){

    }
    protected void setArrayList(Customer customer){
        arrayList.add(customer);
    }

    public ArrayList<Customer> getArrayList() {
        return arrayList;
    }

    public int getHasData() {
        return hasData;
    }

    public void setHasData() {
        if (hasData == 0) hasData++;
    }

    @RequestMapping(value = "/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping(value = "/form")
    public String ShowForm(){
        return "form";
    }

    @RequestMapping(value = "/showResult")
    public String save(HttpServletRequest request) {
        int result = 0;
        try {
            if (getHasData() == 0) {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "bean.xml");
                Customer c2 = (Customer) applicationContext.getBean("c2");
                writeFile(c2.toString());
                arrayList.add(c2);
                Customer c1 = (Customer) applicationContext.getBean("c1");
                writeFile(c1.toString());
                arrayList.add(c1);
                setHasData();
            }
            System.out.println("else else else");
            String fullName = request.getParameter("fullName");
            LocalDate date = LocalDate.parse(request.getParameter("dob"));
            System.out.println(date);
            Date dob = java.sql.Date.valueOf(date);
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            String gender = request.getParameter("gender");
//                checkAvailableData, if have same value return true else return false
            if (!checkAvailableData(email, phoneNumber)){
                Customer cus = new Customer(fullName, dob, email, address, phoneNumber, gender);
                arrayList.add(cus);
                writeFile(cus.toString());
                result = 1;
            }
            request.setAttribute("result",result);
            request.setAttribute("listData",readFile());
            readFile();
        } catch (Exception e) {
            System.out.println("exception");
            System.out.println(e.getMessage());
        }
        return "showResult";
    }

    public boolean checkAvailableData(String email, String phoneNumber){
        boolean resultCheck = false;
        for (Customer c: arrayList){
            System.out.println(c.getFullName());
            System.out.println(c.getPhoneNumber());
            if ( email.equals(c.getEmail()) || phoneNumber.equals(c.getPhoneNumber()) ){
                resultCheck = true;
            }
        }
        return resultCheck;
    }

    public void writeFile(String string){
        try {
            File file = new File("registration.bin");
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(string.getBytes());
            String lineSeparator = System.getProperty("line.separator");
            fileOutputStream.write(lineSeparator.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            System.out.println("Save successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFile(){
        ArrayList<String> listData = new ArrayList<>();
        try (FileInputStream fin = new FileInputStream("registration.bin")) {
            int data = fin.read();
            StringBuilder line = new StringBuilder();
            while (data != -1) {
                if (((char) data == '\n') || ((char) data == '\r')) {
                    listData.add(line.toString());
                    System.out.println(line.toString());
                    line.delete(0, line.length());
                    data = fin.read();
                    continue;
                }
                line.append((char) data);
                data = fin.read();
            }
//            System.out.println("New line: " + line.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listData;
    }
}

