package tsdv;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankingEX {
    private ArrayList<Brands> brands = new ArrayList<>();
    private ArrayList<Customers> customers = new ArrayList<>();

    public void start() {
        boolean check_request = true;
        while (check_request){
            Menu();
            int option = chooseOption();
            switch (option){
                case 0:
                    check_request = false;
                    break;
                case 1:
                    addBrand();
                    break;
                case 2:
                    showBrand();
                    int edit_location = findBrand();
                    if (edit_location == -1) {
                        System.out.println("Do not have that brand name!");
                    }
                    else {
                        editBrand(edit_location);
                    }
                    break;
                case 3:
                    showBrand();
                    int delete_location = findBrand();
                    if (delete_location == -1) {
                        System.out.println("Do not have that brand name!");
                    }
                    else {
                        deleteBrand(delete_location);
                    }
                    break;
                case 4:
                    addCustomer();
                    break;
                case 5:
                    showCustomer();

                    System.out.print("Input customer identification, you want to edit: ");
                    int edit_location_cus = findCustomer();
                    if (edit_location_cus == -1) {
                        System.out.println("Do not have that brand name!");
                    }
                    else {
                        editCustomer(edit_location_cus);
                    }
                    break;
                case 6:
                    showCustomer();
                    System.out.print("Input customer identification, you want to remove: ");
                    int delete_location_cus = findBrand();
                    if (delete_location_cus == -1) {
                        System.out.println("Do not have that identify number!");
                    }
                    else {
                        deleteCustomer(delete_location_cus);
                    }
                    break;
                case 7:
                    showCustomer();
                    System.out.print("Input customer identification, you want to create an account: ");
                    int create_account_locate = findCustomer();
                    if (create_account_locate == -1) {
                        System.out.println("Do not have that identify number!");
                    }
                    else {
                       createAccount(create_account_locate);
                    }
                    break;
                case 8:
                    showCustomer();
                    System.out.print("Input customer identification, you want show balance: ");
                    int show_balance_locate = findCustomer();
                    if (show_balance_locate == -1) {
                        System.out.println("Identify number not exists!");
                    }
                    else {
                        displayBalance(show_balance_locate);
                    }
                    break;
                default:
                    System.out.println("Not matching option! Try again!");
            }
        }
    }

    public void Menu(){
        System.out.println("=====================Menu========================");
        System.out.println("1. Add a brand");
        System.out.println("2. Edit a brand");
        System.out.println("3. Remove a brand");
        System.out.println("4. Add a customer");
        System.out.println("5. Edit a customer");
        System.out.println("6. Remove a customer");
        System.out.println("7. Open an account for a customer");
        System.out.println("8. Display balance for a customer account");
        System.out.println("0. Exit");
    }

    private int chooseOption() {
        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    private void addBrand(){
        Brands brand = new Brands();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input brand information:");
        System.out.print("Brand name: ");
        brand.setName(scanner.nextLine());
        System.out.print("Address: ");
        brand.setAddress(scanner.nextLine());
        brands.add(brand);
    }

    private void showBrand(){
        for (int i = 0; i < brands.size(); i++){
            System.out.println(i+1);
            System.out.print("Name: " + brands.get(i).getName() + "   ||   ");
            System.out.println("Address: " + brands.get(i).getAddress());
        }
    }

    private int findBrand() {
        int locate = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search by brand name: ");
        String name = scanner.nextLine();
        for (int i = 0; i < brands.size(); i++) {
            if (name.equals(brands.get(i).getName())) {
                locate = i;
            }
        }
        return locate;
    }

    private void editBrand(int locate){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: " + brands.get(locate).getName());
        System.out.print("Name edit: ");
        brands.get(locate).setName(scanner.nextLine());
        System.out.println("Address: " + brands.get(locate).getAddress());
        System.out.print("Address edit: ");
        brands.get(locate).setAddress(scanner.nextLine());
    }

    private void deleteBrand(int locate) {
        brands.remove(locate);
    }

    private void showCustomer(){
        for (int i = 0; i < customers.size(); i++){
            System.out.println(i+1);
            System.out.print("Name: " + customers.get(i).getFull_name() + "   ||   ");
            System.out.print("Identify: " + customers.get(i).getIdentify() + "   ||   ");
            System.out.print("Phone number: " + customers.get(i).getNumber() + "   ||   ");
            System.out.print("User_name: " + customers.get(i).getUser_name() + "   ||   ");
            System.out.println("Day of birth: " + customers.get(i).getDob());
        }
    }

    private void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        Customers customer = new Customers();
        System.out.println("Input customer information:");
        System.out.print("Full name: ");
        customer.setFull_name(scanner.nextLine());
        System.out.print("Day of birth(15/3/2000): ");
        customer.setDob(scanner.nextLine());

        boolean identify_exists = false;
        while (!identify_exists){
            System.out.println("WARNING: Identification number have 9 digits and only use number!");
            System.out.print("Identification number: ");
            String ident = checkIdentifyNumber();
            if (customers.size() == 0){
                customer.setIdentify(ident);
                identify_exists = true;
            }else{
                for (int i = 0; i < customers.size(); i++){
                    if(customers.get(i).getIdentify().equals(ident)){
                        System.out.println("Identification exists! Try again!");
                        identify_exists = true;
                    }
                }
                if (identify_exists) {
                    identify_exists = false;
                }else {
                    customer.setIdentify(ident);
                    identify_exists = true;
                }
            }
        }

        boolean phone_exists = false;
        while (!phone_exists){
            System.out.println("WARNING: Phone number have 10 digits, start by 0 and not exists!");
            System.out.print("Phone number: ");
            if (customers.size() == 0){
                customer.setNumber(checkPhoneNumber());
                phone_exists = true;
            }else{
                String ident = checkPhoneNumber();
                for (int i = 0; i < customers.size(); i++){
                    if(customers.get(i).getNumber().equals(ident)){
                        System.out.println("Phone number exists! Try again!");
                        phone_exists = true;
                    }
                }
                if (phone_exists) {
                    phone_exists = false;
                }else {
                    customer.setNumber(ident);
                    phone_exists = true;
                }
            }
        }

        customers.add(customer);
    }

    private int findCustomer() {
        int locate = -1;
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (name.equals(customers.get(i).getIdentify())) {
                locate = i;
            }
        }
        return locate;
    }

    private void editCustomer(int locate){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Full name: " + customers.get(locate).getFull_name());
        System.out.print("Full name edit: ");
        customers.get(locate).setFull_name(scanner.nextLine());
        System.out.println("Day of birth: " + customers.get(locate).getDob());
        System.out.print("Day of birth edit: ");
        customers.get(locate).setDob(scanner.nextLine());

//        customers.get(locate).setNumber(scanner.nextLine());
        String phone = customers.get(locate).getNumber();
        boolean phone_exists = false;
        while (!phone_exists){
            System.out.println("Phone number: " + phone);
            System.out.print("Phone number edit: ");
            String new_phone = checkPhoneNumber();
            if (phone.equals(new_phone)){
                phone_exists = true;
            }else{
                for (int i = 0; i < customers.size(); i++){
                    if(customers.get(i).getNumber().equals(new_phone)){
                        System.out.println("Phone number exists! Try again!");
                        phone_exists = true;
                    }
                }
                if (phone_exists) {
                    phone_exists = false;
                }else {
                    customers.get(locate).setNumber(new_phone);
                    phone_exists = true;
                }
            }
        }
    }

    private void deleteCustomer(int locate) {customers.remove(locate);}

    private void createAccount(int locate) {
        if (customers.get(locate).getUser_name() != null){
            System.out.println("Customer ony have one account. Account have exists!");
        }else{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Your user name is your phone number.");
            customers.get(locate).setUser_name(customers.get(locate).getNumber());
            System.out.print("Set password: ");
            customers.get(locate).setPassword(scanner.nextLine());
            customers.get(locate).setBalance(50);
        }
    }

    private void displayBalance(int locate) {
        System.out.println("Customer name: " + customers.get(locate).getFull_name());
        System.out.println("Customer Identification: " + customers.get(locate).getIdentify());
        System.out.println("Balance: " + customers.get(locate).getBalance());
    }

    private String checkPhoneNumber(){
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = null;
        boolean status = true;
        while (status){
            phoneNumber = scanner.nextLine();
            if (Pattern.matches("[0]{1}[0-9]{9}", phoneNumber)) {
                status = false;
            } else {
                System.out.println("Phone number have 10 digits and start by 0!");
                System.out.print("Phone number: ");
            }
        }
        return phoneNumber;
    }

    private String checkIdentifyNumber() {
        Scanner scanner = new Scanner(System.in);
        String identifyNumber = null;
        boolean status = true;
        while (status){
            identifyNumber = scanner.nextLine();
            if (Pattern.matches("[0-9]{9}", identifyNumber)) {
                status = false;
            } else {
                System.out.println("Identification number have 9 digits!");
                System.out.print("Identification number: ");
            }
        }
        return identifyNumber;
    }
}
