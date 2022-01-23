package tsdv.project_tsdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tsdv.project_tsdv.entity.Customers;
import tsdv.project_tsdv.repository.CustomersRepository;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/login")
public class AccountController {
    @Autowired private CustomersRepository customersRepository;

    @RequestMapping("")
    public String showFormLogAccount(Model model) {
//        Customers customers = new Customers();
//        model.addAttribute("customers",customers);
        return "logAccount";
    }

    @RequestMapping("/check_account")
    public String login_account(Customers customers, Model model,
                                HttpSession session, HttpServletResponse response,
                                @RequestParam(value = "username") String username,
                                @RequestParam(value = "password") String password) throws IOException {
        List<Customers> customersList = customersRepository.findAll();
        for (int i = 0; i < customersList.size(); i++) {
            if(username.equals(customersList.get(i).getUsername())
                && password.equals(customersList.get(i).getPassword())) {
                session.setAttribute("role", customersList.get(i).getRole());
                if (customersList.get(i).getRole().equals("1")) {
                    System.out.println("set role admin");
                    System.out.println(customersList.get(i).getRole());
                    return "redirect:/admin_books";
                } else {
                    System.out.println("set role user");
                    System.out.println(customersList.get(i).getRole());
                    return "redirect:/bookshop";
                }
            }
        }
        return "redirect:/login";
    }
    @RequestMapping("/logOut")
    public String logOutAdmin(){
        return "logAccount";
    }

    @RequestMapping("/create_account")
    public String createCustomerAccount(@RequestParam(value = "username") String username,
                                        @RequestParam(value = "password") String pass) throws IOException {
        List<Customers> customerList = customersRepository.findByNameContaining(username);
        Customers cus = new Customers();
        System.out.println("at create");
        System.out.println(customerList.size());
        if (customerList.size() > 0) {
            System.out.println("false");
            return "redirect:/login";
        } else {
            System.out.println("success");
            cus.setUsername(username);
            cus.setPassword(pass);
            customersRepository.save(cus);
            return "redirect:/bookshop";
        }
    }

    @RequestMapping("/callFormAd")
    public String showAdFormRegit(){return "admin/accountCreate";}

    @RequestMapping("/adAccount")
    public String createAdminAccount(@RequestParam(value = "username") String username,
                                     @RequestParam(value = "password") String pass) throws IOException {
        List<Customers> customerList = customersRepository.findByNameContaining(username);
        Customers cus = new Customers();
        if (customerList.size() > 0) {
            return "redirect:/login";
        } else {
            cus.setUsername(username);
            cus.setPassword(pass);
            cus.setRole("1");
            customersRepository.save(cus);
            return "redirect:/admin_books";
        }
    }
    @RequestMapping("/accountGeneral")
    public String showAllAccount(Model model) {
        List<Customers> customersList = customersRepository.findAll();
        model.addAttribute("customersList", customersList);
        return "admin/accountDetail";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAccount(Model model,
                                @RequestParam(value = "id")Long id) {
        Customers customers = customersRepository.getById(id);
        customersRepository.delete(customers);
        List<Customers> customersList = customersRepository.findAll();
        model.addAttribute("customersList", customersList);
        return "admin/accountDetail";
    }
    @RequestMapping("/showKindOfAccount/ad")
    public String showAllAdminAccount(Model model) {
        List<Customers> customers = customersRepository.findAll();
        List<Customers> customersList = new ArrayList<>();
        System.out.println(customers.size());
        for(int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getRole().equals("1")){
                System.out.println("true");
                System.out.println(customers.get(i).getUsername());
                customersList.add(customers.get(i));
            }
        }
        model.addAttribute("customersList", customersList);
        return "admin/accountDetail";
    }
    @RequestMapping("/showKindOfAccount/cus")
    public String showAllCustomerAccount(Model model) {
        List<Customers> customers = customersRepository.findAll();
        List<Customers> customersList = new ArrayList<>();
        System.out.println(customers.size());
        for(int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getRole().equals("0")){
                System.out.println("true");
                System.out.println(customers.get(i).getUsername());
                customersList.add(customers.get(i));
            }
        }
        model.addAttribute("customersList", customersList);
        return "admin/accountDetail";
    }
}
